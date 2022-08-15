import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import rest.dto.singleUser.Data;
import rest.dto.singleUser.Root;
import rest.dto.singleUser.Support;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetSingleUserTest {

    @Test
    public void getDelayedResponseTest() {
        Root expectedRoot = Root.builder().
                                data(Data.builder()
                                         .id(2)
                                         .email("janet.weaver@reqres.in")
                                         .first_name("Janet")
                                         .last_name("Weaver")
                                         .avatar("https://reqres.in/img/faces/2-image.jpg").build())
                                .support(Support.builder()
                                                .url("https://reqres.in/#support-heading")
                                                .text("To keep ReqRes free, contributions towards server costs are appreciated!").build()).build();

        Root actualRoot = given().
                                  contentType(ContentType.JSON).
                                  accept(ContentType.JSON).
                                  log().ifValidationFails().
                           when().
                                  get("https://reqres.in/api/users/2").
                           then().
                                  statusCode(200).
                                  log().ifValidationFails().
                           extract().
                                     body().as(Root.class);

        assertThat(actualRoot).isEqualTo(expectedRoot);
    }
}