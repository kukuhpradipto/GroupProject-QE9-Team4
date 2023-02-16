package starter;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.UtilsTodos.ConstantTodos;

import java.io.File;

public class TodosAPI {
    //GET
    public static String GET_USER_TODOS = ConstantTodos.BASE_URL + "/todos/{id}";
    @Step("Get user")
    public void setGetUserTodos(int id){
        SerenityRest.given().pathParam("id", id);
    }

    public static  String GET_USERINVALID_TODOS = ConstantTodos.BASE_URL + "/todos/{id}";
    @Step("Get user invalid id")
    public void setGetUserinvalidTodos(String id){
        SerenityRest.given().pathParam("id", id);
    }
    public static String GET_WITHOUT_ID = ConstantTodos.BASE_URL + "/todos";
    @Step("Get user without id")
    public void setGetWithoutId(){
        SerenityRest.given();
    }


    //POST
    public static String POST_CREATE_TODOS = ConstantTodos.BASE_URL + "/todos";
    @Step("Post create user")
    public void setPostCreateTodos(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }


    //PUT
    public static String PUT_UPDATE_TODOS = ConstantTodos.BASE_URL+ "/todos/{id}";
    @Step("Update data user")
    public void setPutUpdateTodos (int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }


    //DELETE
    public static String DELETE_USER_TODOS = ConstantTodos.BASE_URL + "/todos/{id}";
    @Step("Delete user")
    public void setDeleteUserTodos(int id){
        SerenityRest.given().pathParam("id", id);
    }

    public static String DELETE_INVALID_TODOS = ConstantTodos.BASE_URL + "/todos/{id}";
    @Step("Delete invalid id")
    public void setDeleteInvalidTodos(String id){
        SerenityRest.given().pathParam("id", id);
    }

    public  static String DELETE_WITHOUT_ID = ConstantTodos.BASE_URL + "/todos";
    @Step("Delete without id")
    public void setDeleteWithoutId(){
        SerenityRest.given();
    }

}
