package starter.Photos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jnr.constants.Constant;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.UtilsPhotos.ConstantPhotos;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostCreatePhotosStepDef {
    @Steps
    PhotosAPIAutomation photosAPIAutomation;

    //Post Create new Photos with valid json body
    @Given("Post Create new Photos with valid json body")
    public void postCreateNewPhotosWithValidJsonBody() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PostCreatePhotosValidReqbody.json");
        photosAPIAutomation.postCreatePhotos(jsonReq);
    }

    @When("Send request post create photos")
    public void sendRequestPostCreatePhotos() {

        SerenityRest.when().post(PhotosAPIAutomation.POST_CREATE_PHOTOS);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body albumId should be {int}, title is {string}, url is {string} and thumnailUrl is {string}")
    public void responseBodyAlbumIdShouldBeTitleIsUrlIsAndThumnailUrlIs(int albumId, String title, String url, String thumbnailUrl) {
        SerenityRest.then()
                .body(PhotosResponses.ALBUMID,equalTo(albumId))
                .body(PhotosResponses.TITLE,equalTo(title))
                .body(PhotosResponses.URL,equalTo(url))
                .body(PhotosResponses.THUMBNAILURL,equalTo(thumbnailUrl));
    }
    @And("Validate create photos valid json schema")
    public void validateCreatePhotosValidJsonSchema() {
        File jsonSchemaCreatePhotosValid = new File(ConstantPhotos.JSON_SCHEMA_PHOTOS+"PostCreatePhotosValidJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaCreatePhotosValid));
    }


    //Post Create new Photos with invalid json body
    @Given("Post Create new Photos with invalid json body")
    public void postCreateNewPhotosWithInvalidJsonBody() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PostCreatePhotosInvalidReqbody.json");
        photosAPIAutomation.postCreatePhotos(jsonReq);
    }


    //Post Create new Photos with blank parameter on json body
    @Given("Post Create new Photos with blank parameter on json body")
    public void postCreateNewPhotosWithBlankParameterOnJsonBody() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PostCreatePhotosInvalidBlankReqbody.json");
        photosAPIAutomation.postCreatePhotos(jsonReq);

    }

    //Post Create new Photos with extra parameter on json body
    @Given("Post Create new Photos with extra parameter on json body")
    public void postCreateNewPhotosWithExtraParameterOnJsonBody() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PostCreatePhotosInvalidExtraReqbody.json");
        photosAPIAutomation.postCreatePhotos(jsonReq);
    }

    //Post Create new Photos with two parameter only
    @Given("Post Create new Photos with two parameter only")
    public void postCreateNewPhotosWithTwoParameterOnly() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PostCreatePhotosInvalidTwoPathReqbody.json");
        photosAPIAutomation.postCreatePhotos(jsonReq);
    }

    //Post Create new Photos with one parameter only
    @Given("Post Create new Photos with one parameter only")
    public void postCreateNewPhotosWithOneParameterOnly() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PostCreatePhotosInvalidOnePathReqbody.json");
        photosAPIAutomation.postCreatePhotos(jsonReq);
    }
}
