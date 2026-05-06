package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.GrafanaMetricsClient;

public class Hooks {

    private long inicioCenario;

    @Before
    public void antesDoCenario(Scenario scenario) {
        inicioCenario = System.currentTimeMillis();
        System.out.println("🚀 Iniciando cenário: " + scenario.getName());
    }

    @After
    public void depoisDoCenario(Scenario scenario) {
        long fimCenario = System.currentTimeMillis();
        long duracaoMs = fimCenario - inicioCenario;

        String status = scenario.isFailed() ? "failed" : "passed";

        System.out.println("🏁 Cenário finalizado: " + scenario.getName());
        System.out.println("📌 Status: " + status);
        System.out.println("⏱️ Duração: " + duracaoMs + " ms");

        GrafanaMetricsClient.enviarResultadoCenario(
                scenario.getName(),
                status,
                duracaoMs
        );
    }
}