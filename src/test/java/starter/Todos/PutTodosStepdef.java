package starter.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TodosAPI;
import starter.UtilsTodos.ConstantTodos;
import starter.UtilsTodos.TodosReponses;

import java.io.File;

import static org.hamcrest.core.IsEqual.equalTo;


public class PutTodosStepdef {
    @Steps
    TodosAPI todosAPI;

    @Given("Put update user with valid json in id {int}")
    public void putUpdateUserWithValidJsonInId(int id) {
        File jsonReq = new File(ConstantTodos.JSON_REQUEST_PUT+ "/PutUpdateTodos.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(TodosAPI.PUT_UPDATE_TODOS);
    }

    @And("Response body should be title userId is {int}, title is {string}")
    public void responseBodyShouldBeTitleUserIdIsTitleIs(int userId, String title) {
        SerenityRest.then().body(TodosReponses.USER_ID, equalTo(userId)).body(TodosReponses.TITLE,equalTo(title));
    }

    @And("Validate put json schema valid json")
    public void validatePutJsonSchemaValidJson() {
        File jsonSchema = new File(ConstantTodos.JSON_SCHEMA_PUT + "/PutValidParameterJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Put data with invalid file json id {int}")
    public void putDataWithInvalidFileJsonId(int id) {
        File jsonReq= new File(ConstantTodos.JSON_REQUEST_PUT + "/PutUpdateInvalidJson.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @Given("Put data with file json user Id body request is empty id {int}")
    public void putDataWithFileJsonUserIdBodyRequestIsEmptyId(int id) {
        File jsonReq= new File(ConstantTodos.JSON_REQUEST_PUT + "/PutUpdateUserIdEmpty.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @Given("Put data with file json title body request is empty id {int}")
    public void putDataWithFileJsonTitleBodyRequestIsEmptyId(int id) {
        File jsonReq= new File(ConstantTodos.JSON_REQUEST_PUT + "/PutUpdateTitleEmpty.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @Given("Put data with file json completed body request is empty id {int}")
    public void putDataWithFileJsonCompletedBodyRequestIsEmptyId(int id) {
        File jsonReq= new File(ConstantTodos.JSON_REQUEST_PUT + "/PutUpdateCompletedEmpty.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }

    @Given("Put data with file json body request is empty id {int}")
    public void putDataWithFileJsonBodyRequestIsEmptyId(int id) {
        File jsonReq= new File(ConstantTodos.JSON_REQUEST_PUT + "/PutUpdateBodyRequestEmpty.json");
        todosAPI.setPutUpdateTodos(id, jsonReq);
    }
}
