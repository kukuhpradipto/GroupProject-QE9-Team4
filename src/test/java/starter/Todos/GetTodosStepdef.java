package starter.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TodosAPI;
import starter.UtilsTodos.ConstantTodos;
import starter.UtilsTodos.TodosReponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetTodosStepdef {
    @Steps
    TodosAPI todosAPI;

    //GET VALID ID
    @Given("Get data with valid id parameter {int}")
    public void getUserWithValidIdParameter(int id) {
        todosAPI.setGetUserTodos(id);
    }

    @When("Send request get data with id")
    public void sendRequestGetUserWithId() {
        SerenityRest.when().get(TodosAPI.GET_USER_TODOS);
    }

    @Then("Response status code should be {int} Oke")
    public void responseStatusCodeShouldBeOke(int oke) {
        SerenityRest.then().statusCode(oke);
    }

    @And("Response body should be id {int} and userId {int}")
    public void responseBodyShouldBeIdAndUserId(int id, int userId) {
        SerenityRest.then()
                .body(TodosReponses.ID, equalTo(id))
                .body(TodosReponses.USER_ID, equalTo(userId));
    }

    @And("Validator get user json schema with valid parameter id")
    public void validatorGetUserJsonSchemaWitValidParameterId() {
        File jsonSchema = new File(ConstantTodos.JSON_SCHEMA_GET + "/GetValidParameterJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    // INVALID ID SPECIAL CHARACTER
    @Given("Get data with invalid parameter {string}")
    public void getUserWithInvalidParameter(String id) {
        todosAPI.setGetUserinvalidTodos(id);
    }

    @When("Send request get user with invalid parameter")
    public void sendRequestGetUserWithInvalidParameter() {
        SerenityRest.when().get(TodosAPI.GET_USERINVALID_TODOS);
    }

    @Then("Response status code should be {int} Not Found")
    public void responseStatusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @Given("Get data with invalid id {string}")
    public void getDataWithInvalidId(String id) {
        todosAPI.setGetUserinvalidTodos(id);
    }

    @Given("Get data with id parameter {int}")
    public void getDataWithIdParameter(int id) {
        todosAPI.setGetUserTodos(id);
    }

    @Given("Get data without id parameter")
    public void getDataWithoutIdParameter() {
        todosAPI.setGetWithoutId();
    }

    @When("Send request get data without id")
    public void sendRequestGetDataWithoutId() {
        SerenityRest.when().get(TodosAPI.GET_WITHOUT_ID);
    }

    @And("Validator get user json schema without parameter id")
    public void validatorGetUserJsonSchemaWithoutParameterId() {
        File jsonSchema = new File(ConstantTodos.JSON_SCHEMA_GET + "/GetWithoutdParameterJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
