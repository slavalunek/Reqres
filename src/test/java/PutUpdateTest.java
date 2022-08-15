import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.util.Optional.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class PutUpdateTest {

    @Test
    public void putUpdateTest() {
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body("{\n" +
                        "\"name\": \"morpheus\",\n" +
                        "\"job\": \"zion resident\"\n" +
                        "}").
                log().all().
        when().
                put("https://reqres.in/api/users/2").
        then().
                statusCode(200).
                body("name", equalTo("morpheus"),
                        "job", equalTo("zion resident"),
                        "createdAt", not(empty())).
                log().all();
    }
}
