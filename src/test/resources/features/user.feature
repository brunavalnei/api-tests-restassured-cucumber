Feature: Users API

  Scenario: Buscar usuarios com sucesso
    Given que possuo a API de usuarios
    When envio uma requisicao GET para listar usuarios
    Then o status code deve ser 400