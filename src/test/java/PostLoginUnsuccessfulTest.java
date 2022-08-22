import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostLoginUnsuccessfulTest {

    @Test
    public void postLoginUnsuccessfulTest() {
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body("{\n" +
                        "\"email\": \"peter@klaven\"\n" +
                        "}").
                log().all().
        when().
                post("https://reqres.in/api/login").
        then().
                statusCode(400).
                body("error", equalTo("Missing password")).
                log().all();
    }
}
