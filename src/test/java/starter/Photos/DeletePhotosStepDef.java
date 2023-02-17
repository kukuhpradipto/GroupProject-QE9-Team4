package starter.Photos;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class DeletePhotosStepDef {
    @Steps
    PhotosAPIAutomation photosAPIAutomation;
    @Given("Delete photos with valid parameter id {int}")
    public void deletePhotosWithValidParameterIdId(int id) {
        photosAPIAutomation.deletePhotosInt(id);
    }

    @Given("Delete photos with invalid path special character {string}")
    public void deletePhotosWithInvalidPathSpecialCharacter(String specialChar) {
        photosAPIAutomation.deletePhotosString(specialChar);
    }

    @Given("Delete photos with invalid path alphabet {string}")
    public void deletePhotosWithInvalidPathAlphabet(String alphabet) {
        photosAPIAutomation.deletePhotosString(alphabet);
    }

    @Given("Delete photos without parameter id")
    public void deletePhotosWithoutParameterId() {
        photosAPIAutomation.deletePhotosWithoutPathId();
    }

    @Given("Delete photos with unregister path id {int}")
    public void deletePhotosWithUnregisterPathIdId(int id) {
        photosAPIAutomation.deletePhotosInt(id);
    }
}
