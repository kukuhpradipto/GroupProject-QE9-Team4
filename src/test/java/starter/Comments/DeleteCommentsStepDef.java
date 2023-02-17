package starter.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CommentsAPI;
import starter.UtilsComments.ConstantComments;

import java.io.File;

public class DeleteCommentsStepDef {
    @Steps
    CommentsAPI commentsAPI;
    @Given("Delete comments with valid parameter id {int}")
    public void deleteCommentsWithValidParameterId(int id) {commentsAPI.setDeleteComments(id);
    }

    @When("Send request delete comments")
    public void sendRequestDeleteComments() {
        SerenityRest.when().delete(CommentsAPI.DELETE_COMMENTS);
    }

    @And("Validate delete comments json schema valid json")
    public void validateDeleteCommentsJsonSchemaValidJson() {
        File jsonSchema = new File (ConstantComments.JSON_SCHEMA_DELETE + "/DeleteCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Delete comment with invalid parameter id {string}")
    public void deleteCommentWithInvalidParameterId(String id) {
        commentsAPI.setDeleteCommentsInvalid(id);

    }

    @When("Send request delete comment invalid")
    public void sendRequestDeleteCommentInvalid() {
        SerenityRest.when().get(CommentsAPI.DELETE_COMMENTS_INVALID);
    }

    @Then("Response status code should be {int} Bad Request")
    public void responseStatusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
}
