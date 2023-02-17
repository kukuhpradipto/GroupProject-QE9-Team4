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

import static org.hamcrest.Matchers.equalTo;


public class PostAddCommentsStepDef {

    @Steps
    CommentsAPI commentsAPI;

    @Given("Post add comments with valid json")
    public void postAddCommentsWithValidJson() {
        File jsonReq = new File(ConstantComments.JSON_REQUEST_POST + "/PostAddCommentsValid.json");
        commentsAPI.setPostAddComments(jsonReq);
    }

    @When("Send request post add comments")
    public void sendRequestPostAddComments() {
        SerenityRest.when().post(CommentsAPI.POST_ADD_COMMENTS);
    }


    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should be contain name {string} and email is {string}")
    public void responseBodyShouldBeContainNameEmailIsAndBodyIs(String name, String email) {
        SerenityRest.then()
                .body("name", equalTo(name))
                .body("email", equalTo(email));
    }



    @And("Validate post add comments json schema")
    public void validatePostAddCommentsJsonSchema() {
        File jsonSchema = new File(ConstantComments.JSON_SCHEMA_POST + "/PostAddCommentsValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post add comments with invalid json")
    public void postAddCommentsWithInvalidJson() {
        File jsonReq = new File(ConstantComments.JSON_REQUEST_POST+ "/PostAddCommentInvalidJson.json");
    commentsAPI.setPostAddComments(jsonReq);
    }

    @When("Send request post add comments invalid")
    public void sendRequestPostAddCommentsInvalid() {
        SerenityRest.when().post(CommentsAPI.POST_ADD_COMMENTS);
    }
}


