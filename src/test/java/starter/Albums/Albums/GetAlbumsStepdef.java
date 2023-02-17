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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetAlbumsStepdef {

    @Steps
    AlbumsAPI albumsAPI;

    @Given("Get single data album with valid id parameter {int}")
    public void getSingleDataAlbumWithValidIdParameter(int id) {
        albumsAPI.getSingleDataAlbums(id);
    }

    @When("Send request get data with id")
    public void sendRequestGetDataWithId() {
        SerenityRest.when().get(AlbumsAPI.GET_SINGLE_DATA_ALBUMS);
    }

    @Then("Response status code should be {int} OK")
    public void responseStatusCodeShouldBeOke(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body should be id {int} and userId {int}")
    public void responseBodyShouldBeIdAndUserId(int id, int userId){
        SerenityRest.then()
                .body(AlbumsResponses.ID, equalTo(id))
                .body(AlbumsResponses.USER_ID, equalTo(userId));
    }

    @And("Validator get user json schema with valid parameter id")
    public void validatorGetUserJsonSchemaWithValidParameterId(){
        File jsonSchema = new File(ConstantAlbums.JSON_SCHEMA_GET + "/GetValidParamJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //NEGATIVE CASE -> GET WITH INVALID PARAMETER (SPECIAL CHARACTER & Alphabet)
    @Given("Get single data album with invalid parameter {string}")
    public void getSingleDataAlbumWithInvalidParameter(String id) {
        albumsAPI.getSingleDataAlbumsInvalid(id);
    }

    @When("Send request get data with invalid id")
    public void sendRequestGetDataWithInvalidId() {
        SerenityRest.when().get(AlbumsAPI.GET_INVALID_ALBUMS);
    }

    @Then("Response status code should be {int} Not Found")
    public void responseStatusCodeShouldBeNotFound(int notFound){
        SerenityRest.then().statusCode(notFound);
    }

    //NEGATIVE CASE -> GET WITH UNREGISTERED ID
    @Given("Get single data album with unregistered id {int}")
    public void getSingleDataAlbumWithUnregisteredIdId(int id) {
        albumsAPI.getSingleDataAlbums(id);
    }

    //NEGATIVE CASE -> GET WITH ID 0
    @Given("Get single data album with id {int}")
    public void getSingleDataAlbumWithIdId(int id) {
        albumsAPI.getSingleDataAlbums(id);
    }

    //NEGATIVE CASE -> GET WITHOUT ID
    @Given("Get single data album without id parameter")
    public void getSingleDataAlbumWithoutIdParameter(){
        albumsAPI.getListAlbumsWithoutId();
    }

    @When("Send request get data without id")
    public void sendRequestGetDataWithoutId(){
        SerenityRest.when().get(AlbumsAPI.GET_WITHOUT_ID);
    }

    @And("Validator get user json schema without parameter id")
    public void validatorGetUserJsonSchemaWithoutParameterId(){
        File jsonSchema = new File(ConstantAlbums.JSON_SCHEMA_GET + "/GetWithoutParamJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
