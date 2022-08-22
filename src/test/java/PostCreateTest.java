import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.util.Optional.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class PostCreateTest {

    @Test
    public void postCreateTest() {
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body("{\n" +
                "\"name\": \"morpheus\",\n" +
                "\"job\": \"leader\"\n" +
                "}").
                log().all().
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(201).
                body("id",not(empty()),
                        "name", equalTo("morpheus"),
                        "job", equalTo("leader"),
                        "createdAt", not(empty())).
                log().all();
    }
}
