package starter.Photos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.UtilsPhotos.ConstantPhotos;

import java.io.File;

public class PutUpdatePhotosStepDef {
    @Steps
    PhotosAPIAutomation photosAPIAutomation;

    //Put Update new Photos with valid json body
    @Given("Put Update new Photos with valid json body")
    public void putUpdateNewPhotosWithValidJsonBody() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PutUpdatePhotosValidReqbody.json");
        photosAPIAutomation.putUpdatePhotos(jsonReq);
    }
    @When("Send request put update photos")
    public void sendRequestPutUpdatePhotos() {
        SerenityRest.when().put(PhotosAPIAutomation.PUT_UPDATE_PHOTOS);
    }


    //Put Update new Photos with invalid json body
    @Given("Put Update new Photos with invalid json body")
    public void putUpdateNewPhotosWithInvalidJsonBody() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PutUpdatePhotosInvalidReqbody.json");
        photosAPIAutomation.putUpdatePhotos(jsonReq);
    }

    //Put Update new Photos with blank parameter on json body
    @Given("Put Update new Photos with blank parameter on json body")
    public void putUpdateNewPhotosWithBlankParameterOnJsonBody() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PutUpdatePhotosInvalidBlankReqbody.json");
        photosAPIAutomation.putUpdatePhotos(jsonReq);
    }

    //Put Update new Photos with extra parameter on json body
    @Given("Put Update new Photos with extra parameter on json body")
    public void putUpdateNewPhotosWithExtraParameterOnJsonBody() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PutUpdatePhotosInvalidExtraReqbody.json");
        photosAPIAutomation.putUpdatePhotos(jsonReq);
    }

    //Put Update new Photos with two parameter only
    @Given("Put Update new Photos with two parameter only")
    public void putUpdateNewPhotosWithTwoParameterOnly() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PutUpdatePhotosInvalidTwoPathReqbody.json");
        photosAPIAutomation.putUpdatePhotos(jsonReq);
    }

    //Put Update new Photos with two parameter only
    @Given("Put Update new Photos with one parameter only")
    public void putUpdateNewPhotosWithOneParameterOnly() {
        File jsonReq = new File(ConstantPhotos.JSON_REQ_BODY_PHOTOS+"PutUpdatePhotosInvalidOnePathReqbody.json");
        photosAPIAutomation.putUpdatePhotos(jsonReq);
    }
}
