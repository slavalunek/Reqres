import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest {

    @Test
    public void deleteTest() {
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                log().all().
        when().
                delete("https://reqres.in/api/users/2").
        then().
                statusCode(204).
                log().all();
    }
}
