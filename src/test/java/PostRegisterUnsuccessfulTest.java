import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRegisterUnsuccessfulTest {

    @Test
    public void postRegisterUnsuccessfulTest() {
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body("{\n" +
                        "\"email\": \"sydney@fife\"\n" +
                        "}").
                log().all().
        when().
                post("https://reqres.in/api/register").
        then().
                statusCode(400).
                body("error", equalTo("Missing password")).
                log().all();
    }
}
