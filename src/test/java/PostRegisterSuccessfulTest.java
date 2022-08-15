import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRegisterSuccessfulTest {

    @Test
    public void postRegisterSuccessfulTest() {
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}").
                log().all().
        when().
                post("https://reqres.in/api/register").
        then().
                statusCode(200).
                body("id", equalTo(4),
                        "token", equalTo("QpwL5tke4Pnpja7X4")).
                log().all();
    }
}
