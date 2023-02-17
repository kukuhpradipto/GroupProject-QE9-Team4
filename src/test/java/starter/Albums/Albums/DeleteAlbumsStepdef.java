package starter.Albums;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.UtilsAlbums.AlbumsAPI;
import starter.UtilsAlbums.ConstantAlbums;

import java.io.File;

public class DeleteAlbumsStepdef {

    @Steps
    AlbumsAPI albumsAPI;

    //Scenario 1 Delete single data album with valid id parameter
    @Given("Delete single data album with valid id parameter {int}")
    public void deleteSingleDataAlbumWithValidIdParameter(int id) {
        albumsAPI.deleteSingleDataAlbums(id);
    }

    @When("Send request delete data album with id")
    public void sendRequestDeleteDataAlbumWithId() {
        SerenityRest.when().delete(AlbumsAPI.DELETE_SINGLE_DATA_ALBUMS);
    }

    @And("Validator delete data album json schema valid json")
    public void validatorDeleteDataAlbumJsonSchemaValidJson() {
        File jsonSchema = new File(ConstantAlbums.JSON_SCHEMA_DELETE + "/DeleteValidParamJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2 Delete single data album with invalid id parameter
    @Given("Delete single data album with invalid parameter {string}")
    public void deleteSingleDataAlbumWithInvalidParameter(String id) {
        albumsAPI.deleteSingleDataAlbumsInvalid(id);
    }

    @When("Send request delete data album with invalid id")
    public void sendRequestDeleteDataAlbumWithInvalidId() {
        SerenityRest.when().get(AlbumsAPI.DELETE_INVALID_ALBUMS);
    }

    //Scenario 3 Delete single data album with unregistered id
    @Given("Delete single data album with unregistered id {int}")
    public void deleteSingleDataAlbumWithUnregisteredIdId(int id) {
        albumsAPI.deleteSingleDataAlbums(id);
    }

    //Scenario 4 Delete single data album with id 0
    @Given("Delete single data album with id {int}")
    public void deleteSingleDataAlbumWithId(int id) {
        albumsAPI.deleteSingleDataAlbums(id);
    }

    //Scenario 5 Delete single data album without id parameter
    @Given("Delete single data album without id parameter")
    public void deleteSingleDataAlbumWithoutIdParameter() {
        albumsAPI.deleteListAlbumsWithoutId();
    }

    @When("Send request delete data album with id without id")
    public void sendRequestDeleteDataAlbumWithIdWithoutId() {
        SerenityRest.when().delete(AlbumsAPI.DELETE_WITHOUT_ID);
    }

    @And("Validator delete user json schema without parameter id")
    public void validatorDeleteUserJsonSchemaWithoutParameterId() {
        File jsonSchema = new File(ConstantAlbums.JSON_SCHEMA_DELETE + "/DeleteValidParamJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
