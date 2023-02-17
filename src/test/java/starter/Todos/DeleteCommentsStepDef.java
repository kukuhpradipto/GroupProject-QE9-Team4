package starter.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.CommentsAPI;

public class DeleteCommentsStepDef {
    @Steps
    CommentsAPI commentsAPI;
    @Given("Delete comments with valid parameter id {int}")
    public void deleteCommentsWithValidParameterId(int id) {
    }

    @When("Send request delete comments")
    public void sendRequestDeleteComments() {
    }

    @And("Validate delete comments json schema valid json")
    public void validateDeleteCommentsJsonSchemaValidJson() {
    }
}
