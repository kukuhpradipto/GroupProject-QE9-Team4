package starter.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TodosAPI;
import io.restassured.module.jsv.JsonSchemaValidator;
import starter.UtilsTodos.ConstantTodos;

import java.io.File;

public class DeleteTodosStepdef {
    @Steps
    TodosAPI todosAPI;

    @Given("Delete user with valid parameter id {int}")
    public void deleteUserWithValidParameterId(int id) {
        todosAPI.setDeleteUserTodos(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(TodosAPI.DELETE_USER_TODOS);
    }

    @Then("Status code should be {int} OKE")
    public void statusCodeShouldBeNoContent(int oke) {
        SerenityRest.then().statusCode(oke);
    }


    @And("Validate delete json schema valid json")
    public void validateDeleteJsonSchemaValidJson() {
        File jsonSchema = new File(ConstantTodos.JSON_SCHEMA_DELETE + "/DeleteValidIdJSONSchema.json");
        SerenityRest.then().assertThat().body((JsonSchemaValidator.matchesJsonSchema(jsonSchema)));

    }

    @Given("Delete user with valid parameter id {string}")
    public void deleteUserWithValidParameterId(String id) {
        todosAPI.setDeleteInvalidTodos(id);
    }

    @When("Send request delete user invalid")
    public void sendRequestDeleteUserInvalid() {
        SerenityRest.when().get(TodosAPI.DELETE_INVALID_TODOS);
    }

    @Given("Delete data with id parameter unregistered {int}")
    public void deleteDataWithIdParameterUnregistered(int id) {
        todosAPI.setDeleteUserTodos(id);
    }

    @Given("Delete  data without id parameter")
    public void deleteDataWithoutIdParameter() {
        todosAPI.setDeleteWithoutId();
    }

    @When("Send request delete user without Id")
    public void sendRequestDeleteUserWithoutId() {
        SerenityRest.when().delete(TodosAPI.DELETE_WITHOUT_ID);
    }
}
