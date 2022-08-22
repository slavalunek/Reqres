import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostLoginSuccessfulTest {

    @Test
    public void postLoginSuccessfulTest() {
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}").
                log().all().
        when().
                post("https://reqres.in/api/login").
        then().
                statusCode(200).
                body("token", equalTo("QpwL5tke4Pnpja7X4")).
                log().all();
    }
}
