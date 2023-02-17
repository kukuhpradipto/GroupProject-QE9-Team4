package starter.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.CommentsAPI;
import starter.UtilsComments.CommentsResponses;
import starter.UtilsComments.ConstantComments;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class GetCommentsStepDef {
    @Steps
    CommentsAPI commentsAPI;

    @Given("Get comments with valid parameter id {int}")
    public void getCommentsWithValidParameterIdId(int id) { commentsAPI.setGetComments(id);
    }

    @When("Send get comments request")
    public void sendGetCommentsRequest() {
        SerenityRest.when().get(CommentsAPI.GET_COMMENTS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body should be postId {int} and id {int}")
    public void responseBodyShouldBeIdId(int postId, int id) {
        SerenityRest.then()
                .body(CommentsResponses.POST_ID, equalTo(postId))
                .body(CommentsResponses.ID, equalTo(id));
    }

    @And("Validate get comments json schema with valid parameter id")
    public void validateGetCommentJsonSchemaWithValidParameterId() {
        File jsonSchema = new File(ConstantComments.JSON_SCHEMA_GET +"/GetValidParameterIdJsonSchema.json");

    }
    //INVALID GET COMMENTS
    @Given("Get comments with invalid parameter id using alphabet {string}")
    public void getCommentsWithInvalidParameterIdUsingAlphabet(String id) {
        commentsAPI.setGetCommentsInvalid(id);
    }

    @When("Send request get comments invalid parameter id")
    public void sendRequestGetCommentsInvalidParameterId() {
        SerenityRest.when().get(CommentsAPI.GET_COMMENTS_INVALID);
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int badRequest) {SerenityRest.then().statusCode(badRequest);
    }



}
