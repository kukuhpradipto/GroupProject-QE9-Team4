package starter.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.CommentsAPI;
import starter.UtilsComments.ConstantComments;
import starter.UtilsTodos.ConstantTodos;

import java.io.File;

public class PutUpdateCommentsStepDef {
    @Steps
    CommentsAPI commentsAPI;
    @Given("Put update comments with valid json with id {int}")
    public void putUpdateCommentsWithValidJsonWithId(int id) {
        File jsonReq = new File(ConstantComments.JSON_REQUEST_PUT + "/PutUpdateCommentsValid.json");
        commentsAPI.setPutUpdateComments(id, jsonReq);
    }

    @When("Send request put update comments")
    public void sendRequestPutUpdateComments() {
        SerenityRest.when().put(CommentsAPI.PUT_UPDATE_COMMENTS);
    }

    @And("Validate put update comments json schema")
    public void validatePutUpdateCommentsJsonSchema() {
        File jsonSchema = new File (ConstantComments.JSON_SCHEMA_PUT + "/PutUpdateCommentsValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
