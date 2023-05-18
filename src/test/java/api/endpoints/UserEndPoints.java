package api.endpoints;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints 
{
	static ResourceBundle getURL()
	{
		ResourceBundle urls = ResourceBundle.getBundle("Routes");
		return urls;
	}
   public static Response createUser(User payload)
   {
	   Response response = given()
	     .contentType(ContentType.JSON)
	     .accept(ContentType.JSON)
	     .body(payload)
	   .when()
	    .post(getURL().getString("user_post_URL"));
	   return response;
   }
   
   public static Response getUserByName(String userName)
   {
	   Response response =given()
	       .pathParam("username",userName)
	   .when()
	     .get(Routes.user_Get_URL);
	   return response;
   }
   public static Response updateUser(String userName,User payload)
   {
	   Response response = given()
	     .contentType(ContentType.JSON)
	     .accept(ContentType.JSON)
	     .pathParam("userName",userName)
	     .body(payload)
	   .when()
	    .put(Routes.user_Put_URL);
	   return response;
   }
   public static Response deleteUser(String userName)
   {
	   Response response = given()
	      .pathParam("username", userName)
	   .when()
	    .delete(Routes.user_delete_URL);
	   return response;
   }
}
