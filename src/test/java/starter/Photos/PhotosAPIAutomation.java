package starter.Photos;

import io.restassured.http.ContentType;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.UtilsPhotos.ConstantPhotos;

import java.io.File;

public class PhotosAPIAutomation {
    public static String GET_SINGLE_PHOTOS = ConstantPhotos.BASE_URL+"/photos/{id}";
    @Step("Get single photos int")
    public void getSinglePhotosInt(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single photos string")
    public void getSinglePhotosString(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    public static String GET_SINGLE_PHOTOS_WIHOUT_PATH_ID = ConstantPhotos.BASE_URL+"/photos";
    @Step("Get single photos without path id")
    public void getSinglePhotosWithoutPathId(){
        SerenityRest.given();
    }

    public static String POST_CREATE_PHOTOS = ConstantPhotos.BASE_URL+"/posts";
    @Step("Post create photos")
    public void postCreatePhotos(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    public static String PUT_UPDATE_PHOTOS = ConstantPhotos.BASE_URL+"/posts/1";
    @Step("Put update photos")
    public void putUpdatePhotos(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String DELETE_PHOTOS = ConstantPhotos.BASE_URL+"/posts/{id}";
    @Step("Get single photos int")
    public void deletePhotosInt(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get single photos string")
    public void deletePhotosString(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    public static String DELETE_PHOTOS_WITHOUT_PATH_ID = ConstantPhotos.BASE_URL+"/posts";
    @Step("Delete photos without path id")
    public void deletePhotosWithoutPathId(){
        SerenityRest.given();
    }
}
