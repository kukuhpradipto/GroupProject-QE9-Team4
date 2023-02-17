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
import starter.UtilsTodos.TodosReponses;

import java.io.File;

import static org.hamcrest.core.IsEqual.equalTo;

public class PostTodosStepdef {
    @Steps
    TodosAPI todosAPI;

    @Given("Post create new user with valid json file")
    public void postCreateNewUserWithValidJsonFile() {
        File jsonReq = new File(ConstantTodos.JSON_REQUEST_POST + "/PostCreateValidJson.json");
        todosAPI.setPostCreateTodos(jsonReq);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(TodosAPI.POST_CREATE_TODOS);
    }

    @Then("Response status code should be {int} Created")
    public void responseStatusCodeShouldBeCreated(int oke) {
        SerenityRest.then().statusCode(oke);
    }

    @And("Response body should be userId is {int}")
    public void resposeBodyShouldBeUserIdIsAndCompetedIsFalse(int userId) {
        SerenityRest.then()
                .body(TodosReponses.USER_ID, equalTo(userId));
    }

    @And("Validator post create user json schema")
    public void validatorPostCreateUserJsonSchema() {
        File jsonSchema = new File(ConstantTodos.JSON_SCHEMA_POST + "/PostValidParameterJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post create new user with invalid json")
    public void postCreateNewUserWithInvalidJsonFile() {
        File jsonReq = new File(ConstantTodos.JSON_REQUEST_POST+ "/PostCreateInvalidJson.json");
        todosAPI.setPostCreateTodos(jsonReq);
    }

    @Given("Post data with file json user id  body request is empty")
    public void postDataWithFileJsonUserIdBodyRequestIsEmpty() {
        File jsonReq = new File(ConstantTodos.JSON_REQUEST_POST + "/PostCreateUserIdEmpty.json");
        todosAPI.setPostCreateTodos(jsonReq);
    }

    @Given("Post data with file json title body request is empty")
    public void postDataWithFileJsonTitleBodyRequestIsEmpty() {
        File jsonReq = new File(ConstantTodos.JSON_REQUEST_POST + "/PostCreateTitleEmpty.json");
        todosAPI.setPostCreateTodos(jsonReq);
    }

    @Given("Post data with file json completed body request is empty")
    public void postDataWithFileJsonCompletedBodyRequestIsEmpty() {
        File jsonReq = new File(ConstantTodos.JSON_REQUEST_POST + "/PostCreateCompletedEmpty.json");
        todosAPI.setPostCreateTodos(jsonReq);
    }

    @Given("Post data with file json body request is empty")
    public void postDataWithFileJsonBodyRequestIsEmpty() {
        File jsonReq = new File(ConstantTodos.JSON_REQUEST_POST + "/PostCreateWithoutBodyRequest.json");
        todosAPI.setPostCreateTodos(jsonReq);
    }
}
