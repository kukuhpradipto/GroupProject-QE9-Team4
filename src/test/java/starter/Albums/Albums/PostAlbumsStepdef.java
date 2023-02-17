package starter.Albums;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.UtilsAlbums.AlbumsAPI;
import starter.UtilsAlbums.AlbumsResponses;
import starter.UtilsAlbums.ConstantAlbums;
import starter.UtilsTodos.ConstantTodos;

import static org.hamcrest.core.IsEqual.equalTo;
import java.io.File;


public class PostAlbumsStepdef {

    @Steps
    AlbumsAPI albumsAPI;

    //Scenario 1 POST Valid JSON
    @Given("Post create new album with valid json file")
    public void postCreateNewAlbumWithValidJsonFile() {
        File jsonReq = new File(ConstantAlbums.JSON_REQUEST_POST + "/PostCreateValidJSON.json");
        albumsAPI.postCreateAlbums(jsonReq);
    }

    @When("Send request post create new album")
    public void sendRequestPostCreateNewAlbum() {
        SerenityRest.when().post(AlbumsAPI.POST_CREATE_ALBUMS);
    }

    @Then("Response status code should be {int} Created")
    public void responseStatusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should be userId is {int} and title {string}")
    public void responseBodyShouldBeUserIdIsAndTitle(int userId, String title) {
        SerenityRest.then()
                .body(AlbumsResponses.USER_ID, equalTo(userId))
                .body(AlbumsResponses.TITLE, equalTo(title));
    }

    @And("Validator post create album json schema")
    public void validatorPostCreateAlbumJsonSchema() {
        File jsonSchema = new File(ConstantAlbums.JSON_SCHEMA_POST + "/PostValidParamJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2 POST invalid JSON
    @Given("Post create new album with invalid data type json file")
    public void postCreateNewAlbumWithInvalidDataTypeJsonFile() {
        File jsonReq = new File(ConstantAlbums.JSON_REQUEST_POST+ "/PostCreateInvalidJSON.json");
        albumsAPI.postCreateAlbums(jsonReq);
    }

    @Then("Response status code should be {int} Bad Request")
    public void responseStatusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    //Scenario 3 Post with 1 param
    @Given("Post create album with one parameter only")
    public void postCreateAlbumWithOneParameterOnly() {
        File jsonReq = new File(ConstantAlbums.JSON_REQUEST_POST+ "/PostCreateOneParamJSON.json");
        albumsAPI.postCreateAlbums(jsonReq);
    }

    //Scenario 4 Post with empty file json
    @Given("Post create album with empty file json body request")
    public void postCreateAlbumWithEmptyFileJsonBodyRequest() {
        File jsonReq = new File(ConstantAlbums.JSON_REQUEST_POST+ "/PostCreateEmptyJSON.json");
        albumsAPI.postCreateAlbums(jsonReq);
    }

    //Scenario 5 Post with extra parameter
    @Given("Post create album with extra parameter")
    public void postCreateAlbumWithExtraParameter() {
        File jsonReq = new File(ConstantAlbums.JSON_REQUEST_POST+ "/PostCreateExtraParamJSON.json");
        albumsAPI.postCreateAlbums(jsonReq);
    }


}
