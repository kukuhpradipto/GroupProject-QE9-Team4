package starter.Albums;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.UtilsAlbums.AlbumsAPI;
import starter.UtilsAlbums.AlbumsResponses;
import starter.UtilsAlbums.ConstantAlbums;
import starter.UtilsTodos.TodosReponses;

import java.io.File;

import static org.hamcrest.core.IsEqual.equalTo;

public class PutAlbumsStepdef {

    @Steps
    AlbumsAPI albumsAPI;

    //Scenario 1 Put update data album with valid json parameter
    @Given("Put update data album with valid json in id {int}")
    public void putUpdateDataAlbumWithValidJsonInIdO(int id) {
        File jsonReq = new File(ConstantAlbums.JSON_REQUEST_PUT + "/PutValidParamJSON.json");
        albumsAPI.putUpdateAlbums(id, jsonReq);
    }

    @When("Send request put update data album")
    public void sendRequestPutUpdateDataAlbum() {
        SerenityRest.when().put(AlbumsAPI.PUT_UPDATE_ALBUMS);
    }

    //Scenario 2 Put update data album with invalid data type json parameter
    @Given("Put update data album with invalid data type json in id {int}")
    public void putUpdateDataAlbumWithInvalidDataTypeJsonInId(int id) {
        File jsonReq = new File(ConstantAlbums.JSON_REQUEST_PUT + "/PutInvalidDataTypeJSON.json");
        albumsAPI.putUpdateAlbums(id, jsonReq);
    }

    //Scenario 3 Put update data album with empty file json body request
    @Given("Put update data album with empty file json body request id {int}")
    public void putUpdateDataAlbumWithEmptyFileJsonBodyRequestId(int id) {
        File jsonReq = new File(ConstantAlbums.JSON_REQUEST_PUT + "/PutUpdateBodyRequestEmpty.json");
        albumsAPI.putUpdateAlbums(id, jsonReq);
    }


}
