package utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

public class GrafanaMetricsClient {

    private static final String LOKI_URL = System.getenv("GRAFANA_LOKI_URL");
    private static final String GRAFANA_USER = System.getenv("GRAFANA_USER");
    private static final String GRAFANA_TOKEN = System.getenv("GRAFANA_TOKEN");

    public static void enviarResultadoCenario(
            String nomeCenario,
            String status,
            long duracaoMs) {
        if (LOKI_URL == null || GRAFANA_USER == null || GRAFANA_TOKEN == null) {
            System.out.println("⚠️ Variáveis do Grafana não configuradas. Métrica não enviada.");
            return;
        }

        try {
            long timestampNanos = Instant.now().toEpochMilli() * 1_000_000;

            String mensagem = String.format(
                    "cenario='%s' status='%s' duracaoMs=%d",
                    limparTexto(nomeCenario),
                    status,
                    duracaoMs);
            String payload = """
                    {
                      "streams": [
                        {
                          "stream": {
                            "job": "api-tests-restassured-cucumber",
                            "ambiente": "github-actions",
                            "status": "%s"
                          },
                          "values": [
                            ["%d", "%s"]
                          ]
                        }
                      ]
                    }
                    """.formatted(status, timestampNanos, mensagem);

            URL url = new URL(LOKI_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            String auth = GRAFANA_USER + ":" + GRAFANA_TOKEN;
            String encodedAuth = Base64.getEncoder()
                    .encodeToString(auth.getBytes(StandardCharsets.UTF_8));

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic " + encodedAuth);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = conn.getResponseCode();

            if (responseCode >= 200 && responseCode < 300) {
                System.out.println("✅ Métrica enviada para Grafana: " + mensagem);
            } else {
                System.out.println("❌ Erro ao enviar métrica para Grafana. HTTP: " + responseCode);
            }

            conn.disconnect();

        } catch (Exception e) {
            System.out.println("❌ Erro ao enviar métrica para Grafana: " + e.getMessage());
        }
    }

    private static String limparTexto(String texto) {
        if (texto == null) {
            return "";
        }

        return texto
                .replace("\\", "\\\\")
                .replace("\"", "'")
                .replace("\n", " ")
                .replace("\r", " ");
    }
}