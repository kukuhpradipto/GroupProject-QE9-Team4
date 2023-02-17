package starter.UtilsAlbums;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.UtilsTodos.ConstantTodos;

import java.io.File;

public class AlbumsAPI {

    //Method GET
    public static String GET_SINGLE_DATA_ALBUMS = ConstantAlbums.BASE_URL + "/albums/{id}";
    @Step("Get single data albums")
    public void getSingleDataAlbums(int id){
        SerenityRest.given().pathParam("id", id);
    }

    public static  String GET_INVALID_ALBUMS = ConstantAlbums.BASE_URL + "/albums/{id}";
    @Step("Get single data album with invalid id")
    public void getSingleDataAlbumsInvalid(String id){
        SerenityRest.given().pathParam("id", id);
    }
    public static String GET_WITHOUT_ID = ConstantAlbums.BASE_URL + "/albums";
    @Step("Get list albums without id")
    public void getListAlbumsWithoutId(){
        SerenityRest.given();
    }

    //Method POST
    public static String POST_CREATE_ALBUMS = ConstantTodos.BASE_URL + "/albums";
    @Step("Post create album")
    public void postCreateAlbums(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }


    //Method PUT
    public static String PUT_UPDATE_ALBUMS = ConstantAlbums.BASE_URL+ "/albums/{id}";
    @Step("Update data album")
    public void putUpdateAlbums (int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }

    //Method DELETE
    public static String DELETE_SINGLE_DATA_ALBUMS = ConstantAlbums.BASE_URL + "/albums/{id}";
    @Step("Delete single data albums")
    public void deleteSingleDataAlbums(int id){
        SerenityRest.given().pathParam("id", id);
    }

    public static  String DELETE_INVALID_ALBUMS = ConstantAlbums.BASE_URL + "/albums/{id}";
    @Step("Delete single data album with invalid id")
    public void deleteSingleDataAlbumsInvalid(String id){
        SerenityRest.given().pathParam("id", id);
    }
    public static String DELETE_WITHOUT_ID = ConstantAlbums.BASE_URL + "/albums";
    @Step("Delete list albums without id")
    public void deleteListAlbumsWithoutId(){
        SerenityRest.given();
    }

}
