package starter;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.UtilsComments.ConstantComments;

import java.io.File;

public class CommentsAPI {


    //GET COMMENTS
    public static String GET_COMMENTS = ConstantComments.BASE_URL + "/comments/{id}";
    @Step("Get comments")
    public void setGetComments(int id){
        SerenityRest.given().pathParam("id",id);
    }

    public static String GET_COMMENTS_INVALID = ConstantComments.BASE_URL + "/comments/{id}";
    @Step("Get comments invalid")
    public void setGetCommentsInvalid(String id) {SerenityRest.given().pathParam("id",id);}


    //POST ADD COMMENTS
    public static String POST_ADD_COMMENTS = ConstantComments.BASE_URL + "/comments";
    @Step("Post add comments")
    public void setPostAddComments(File json) { SerenityRest.given().contentType(ContentType.JSON).body(json);}


    //PUT UPDATE COMMENTS
    public static String PUT_UPDATE_COMMENTS = ConstantComments.BASE_URL+ "/comments/{id}";
    @Step("Put Update Comments")
    public void setPutUpdateComments (int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }






}
