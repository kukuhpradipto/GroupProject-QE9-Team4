package starter.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TodosAPI;

import java.io.File;

import static org.hamcrest.core.IsEqual.equalTo;


public class PutTodosStepdef {
    @Steps
    TodosAPI todosAPI;

    @Given("Put update user with valid json in id {int}")
    public void putUpdateUserWithValidJsonInId(int id) {
        File jsonReq = new File(TodosAPI.DIR + "/src/test/resources/JSON/ReqBody/Todos/PutUpdateTodos/PutUpdateTodos.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(TodosAPI.PUT_UPDATE_TODOS);
    }

    @And("Response body should be title userId is {int}, title is {string}")
    public void responseBodyShouldBeTitleUserIdIsTitleIs(int userId, String title) {
        SerenityRest.then().body("userId", equalTo(userId)).body("title",equalTo(title));
    }

    @And("Validate put json schema valid json")
    public void validatePutJsonSchemaValidJson() {
        File jsonSchema = new File(TodosAPI.DIR + "/src/test/resources/JSON/JSONSchema/Todos/PutTodosSchemaTodos/PutValidParameterJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Put data with invalid file json id {int}")
    public void putDataWithInvalidFileJsonId(int id) {
        File jsonReq= new File(TodosAPI.DIR + "/src/test/resources/JSON/ReqBody/Todos/PutUpdateTodos/PutUpdateInvalidJson.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @Given("Put data with file json user Id body request is empty id {int}")
    public void putDataWithFileJsonUserIdBodyRequestIsEmptyId(int id) {
        File jsonReq= new File(TodosAPI.DIR + "/src/test/resources/JSON/ReqBody/Todos/PutUpdateTodos/PutUpdateUserIdEmpty.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @Given("Put data with file json title body request is empty id {int}")
    public void putDataWithFileJsonTitleBodyRequestIsEmptyId(int id) {
        File jsonReq= new File(TodosAPI.DIR + "/src/test/resources/JSON/ReqBody/Todos/PutUpdateTodos/PutUpdateTitleEmpty.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @Given("Put data with file json completed body request is empty id {int}")
    public void putDataWithFileJsonCompletedBodyRequestIsEmptyId(int id) {
        File jsonReq= new File(TodosAPI.DIR + "/src/test/resources/JSON/ReqBody/Todos/PutUpdateTodos/PutUpdateCompletedEmpty.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @Given("Put data with file json body request is empty id {int}")
    public void putDataWithFileJsonBodyRequestIsEmptyId(int id) {
        File jsonReq= new File(TodosAPI.DIR + "/src/test/resources/JSON/ReqBody/Todos/PutUpdateTodos/PutUpdateBodyRequestEmpty.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }
}
