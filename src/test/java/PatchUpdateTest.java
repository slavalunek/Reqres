import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.util.Optional.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class PatchUpdateTest {

    @Test
    public void patchUpdateTest() {
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body("{\n" +
                        "\"name\": \"morpheus 3\",\n" +
                        "\"job\": \"zion resident 3\"\n" +
                        "}").
                log().all().
        when().
                patch("https://reqres.in/api/users/2").
        then().
                statusCode(200).
                body("name", equalTo("morpheus 3"),
                        "job", equalTo("zion resident 3"),
                        "createdAt", not(empty())).
                log().all();
    }
}
