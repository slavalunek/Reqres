import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserNotFoundTest {

    @Test
    public void getSingleUserNotFoundTest() {
         given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                log().ifValidationFails().
         when().
                get("https://reqres.in/api/users/23").
         then().
                statusCode(404).
                body(equalTo("{}")).
                log().ifValidationFails();
    }
}