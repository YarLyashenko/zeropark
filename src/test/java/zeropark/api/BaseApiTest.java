package zeropark.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;

@Category(ApiTests.class)
public abstract class BaseApiTest {
    public static final String TOKEN
            = System.getProperty("apiToken", "AAABYhohhO3t1s9WkfMAX7EnIJ/70M3pM3qj0Or5HV8v4Pg72rqFHja3Xx8XsRSyC5LK8W6LBbDvp++N7t/3Rg==");
    public static final String API_URL = "https://demo.zeropark.com/api";
    public static final RequestSpecification TOKEN_HEADER_SPEC = new RequestSpecBuilder()
            .setBaseUri(API_URL)
            .addHeader("api-token", TOKEN)
            .build();

    @BeforeClass
    public static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}
