package starter.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CommentsAPI;
import starter.UtilsComments.ConstantComments;

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

    @Given("Put update comments with invalid json with id {int}")
    public void putUpdateCommentsWithInvalidJsonWithId(int id) {
        File jsonReq = new File(ConstantComments.JSON_REQUEST_PUT + "/PutUpdateInvalidJson.json");
    commentsAPI.setPutUpdateCommentsInvalid(id,jsonReq );
    }

    @Given("Put update comments with empty body json on email with id {int}")
    public void putUpdateCommentsWithEmptyBodyJsonOnEmailWithId(int id) {   File jsonReq = new File(ConstantComments.JSON_REQUEST_PUT + "/PutUpdateInvalidJsoWithEmptyEmail.json");
        commentsAPI.setPutUpdateCommentsInvalid(id,jsonReq );
    }


    @Given("Put update comments with empty body json on name with id {int}")
    public void putUpdateCommentsWithEmptyBodyJsonOnNameWithId(int id) {  File jsonReq = new File(ConstantComments.JSON_REQUEST_PUT + "/PutUpdateInvalidJsoWithEmptyName.json");
        commentsAPI.setPutUpdateCommentsInvalid(id,jsonReq );
    }


}
