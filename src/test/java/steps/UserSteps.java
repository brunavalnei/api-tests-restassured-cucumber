package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class UserSteps {

    private Response response;

    @Given("que possuo a API de usuarios")
    public void quePossuoAApiDeUsuarios() {
        baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("envio uma requisicao GET para listar usuarios")
    public void envioUmaRequisicaoGETParaListarUsuarios() {
        response = given()
                .when()
                .get("/users");
    }

    @Then("o status code deve ser {int}")
    public void oStatusCodeDeveSer(int statusCode) {
        response.then()
                .statusCode(statusCode)
                .body("size()", greaterThan(0));
    }
}