import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import rest.dto.delayedResponse.Datum;
import rest.dto.delayedResponse.User;
import rest.dto.delayedResponse.Support;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetDelayedResponseTest {

    @Test
    public void getDelayedResponseTest() {
        User expectedUser = User.builder()
                                .page(1)
                                .per_page(6)
                                .total(12)
                                .total_pages(2)
                                .data(List.of(Datum.builder()
                                                   .id(1)
                                                   .email("george.bluth@reqres.in")
                                                   .first_name("George")
                                                   .last_name("Bluth")
                                                   .avatar("https://reqres.in/img/faces/1-image.jpg").build()))
                                .data(List.of(Datum.builder()
                                                   .id(2)
                                                   .email("janet.weaver@reqres.in")
                                                   .first_name("Janet")
                                                   .last_name("Weaver")
                                                   .avatar("https://reqres.in/img/faces/2-image.jpg").build()))
                                .data(List.of(Datum.builder()
                                                   .id(3)
                                                   .email("emma.wong@reqres.in")
                                                   .first_name("Emma")
                                                   .last_name("Wong")
                                                   .avatar("https://reqres.in/img/faces/3-image.jpg").build()))
                                .data(List.of(Datum.builder()
                                                   .id(4)
                                                   .email("eve.holt@reqres.in")
                                                   .first_name("Eve")
                                                   .last_name("Holt")
                                                   .avatar("https://reqres.in/img/faces/4-image.jpg").build()))
                                .data(List.of(Datum.builder()
                                                   .id(5)
                                                   .email("charles.morris@reqres.in")
                                                   .first_name("Charles")
                                                   .last_name("Morris")
                                                   .avatar("https://reqres.in/img/faces/5-image.jpg").build()))
                                .data(List.of(Datum.builder()
                                                   .id(6)
                                                   .email("tracey.ramos@reqres.in")
                                                   .first_name("Tracey")
                                                   .last_name("Ramos")
                                                   .avatar("https://reqres.in/img/faces/6-image.jpg").build()))
                                .support(Support.builder()
                                                   .url("https://reqres.in/#support-heading")
                                                   .text("To keep ReqRes free, contributions towards server costs are appreciated!").build()).build();

        User actualUser = given().
                                  contentType(ContentType.JSON).
                                  accept(ContentType.JSON).
                                  log().ifValidationFails().
                          when().
                                  get("https://reqres.in/api/users?delay=3").
                          then().
                                  statusCode(200).
                                  log().ifValidationFails().
                          extract().
                                  body().as(User.class);

        assertThat(actualUser).isEqualTo(expectedUser);
    }
}