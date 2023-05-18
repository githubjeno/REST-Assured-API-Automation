package api.endpoints;

public class Routes 
{
    public static String base_URL="https://petstore.swagger.io/v2";
    //pet module
    public static String pet_Post_URL=base_URL+"/pet/123/uploadImage";
    
    //user module
    public static String user_Post_URL=base_URL+"/user";
    public static String user_Get_URL=base_URL+"/user/{username}";
    public static String user_Put_URL=base_URL+"/user/{username}";  
    public static String user_delete_URL=base_URL+"/user/{username}";




}