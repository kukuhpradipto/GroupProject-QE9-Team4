package starter.UtilsAlbums;

public class ConstantAlbums {
    public static final String DIR = System.getProperty("user.dir"); // untuk mengambil user directory

    public static String BASE_URL = "https://jsonplaceholder.typicode.com";


    public static String JSON_SCHEMA_GET = DIR + "/src/test/resources/JSON/JSONSchema/Albums/GetJsonSchemaAlbums";

    public static String JSON_REQUEST_POST = DIR + "/src/test/resources/JSON/ReqBody/Albums/PostCreateAlbums";

    public static String JSON_SCHEMA_POST = DIR + "/src/test/resources/JSON/JSONSchema/Albums/PostJsonSchemaAlbums";

    public static String JSON_REQUEST_PUT = DIR + "/src/test/resources/JSON/ReqBody/Albums/PutUpdateAlbums";

    public static String JSON_SCHEMA_PUT = DIR + "/src/test/resources/JSON/JSONSchema/Albums/PutJsonSchemaAlbums";

    public static String JSON_SCHEMA_DELETE = DIR + "/src/test/resources/JSON/JSONSchema/Albums/DeleteJsonSchemaAlbums";
}
