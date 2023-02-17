package starter.Photos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetSinglePhotosStepDef {
    @Steps
    PhotosAPIAutomation photosAPIAutomation;

    //Get single data with registered path id
    @Given("Get single data with registered path id {int}")
    public void getSingleDataWithRegisteredPathIdId(int id) {
        photosAPIAutomation.getSinglePhotosInt(id);
    }

    @When("Send request get single photos")
    public void sendRequestGetSinglePhotos() {
        SerenityRest.when().get(PhotosAPIAutomation.GET_SINGLE_PHOTOS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    //Get single data with unregistered path id
    @Given("Get single data with unregistered path id {int}")
    public void getSingleDataWithUnregisteredPathIdId(int id) {
        photosAPIAutomation.getSinglePhotosInt(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    //Get single data with invalid path (special character)
    @Given("Get single data with invalid path special character {string}")
    public void getSingleDataWithInvalidPathSpecialCharacter(String specialChar) {
        photosAPIAutomation.getSinglePhotosString(specialChar);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    //Get single data with invalid path (alphabet)
    @Given("Get single data with invalid path alphabet {string}")
    public void getSingleDataWithInvalidPathAlphabet(String alphabet) {
        photosAPIAutomation.getSinglePhotosString(alphabet);

    }

    //Get single data without path id
    @Given("Get single data without path id")
    public void getSingleDataWithoutPathId() {
        photosAPIAutomation.getSinglePhotosWithoutPathId();
    }

    @When("Send request get single photos without path id")
    public void sendRequestGetSinglePhotosWithoutPathId() {
        SerenityRest.when().get(PhotosAPIAutomation.GET_SINGLE_PHOTOS_WIHOUT_PATH_ID);
    }
}
