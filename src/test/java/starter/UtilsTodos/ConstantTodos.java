package starter.UtilsTodos;

public class ConstantTodos {

    public static final String DIR = System.getProperty("user.dir"); // untuk mengambil user directory

    public static String BASE_URL = "https://jsonplaceholder.typicode.com";

//    public static String JSON_REQUEST_GET

    public static String JSON_SCHEMA_GET = DIR + "/src/test/resources/JSON/JSONSchema/Todos/GetJsonSchemaTodos";

    public static String JSON_REQUEST_POST = DIR + "/src/test/resources/JSON/ReqBody/Todos/PostCreateTodos";

    public static String JSON_SCHEMA_POST = DIR + "/src/test/resources/JSON/JSONSchema/Todos/PostJsonSchemaTodos";

    public static String JSON_REQUEST_PUT = DIR + "/src/test/resources/JSON/ReqBody/Todos/PutUpdateTodos";

    public static String JSON_SCHEMA_PUT = DIR + "/src/test/resources/JSON/JSONSchema/Todos/PutTodosSchemaTodos";

    public static String JSON_SCHEMA_DELETE = DIR + "/src/test/resources/JSON/JSONSchema/Todos/DeleteJsonSchemaTodos";

}
