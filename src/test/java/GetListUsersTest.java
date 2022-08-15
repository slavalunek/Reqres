import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import rest.dto.listUsers.Datum;
import rest.dto.listUsers.Root;
import rest.dto.listUsers.Support;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class GetListUsersTest {

    @Test
    public void getListUsersTest() {
        Root expectedRoot = Root.builder()
                                .page(2)
                                .per_page(6)
                                .total(12)
                                .total_pages(2)
                                .data(List.of(Datum.builder()
                                                   .id(7)
                                                   .email("michael.lawson@reqres.in")
                                                   .first_name("Michael")
                                                   .last_name("Lawson")
                                                   .avatar("https://reqres.in/img/faces/7-image.jpg").build(),
                                        Datum.builder()
                                             .id(8)
                                             .email("lindsay.ferguson@reqres.in")
                                             .first_name("Lindsay")
                                             .last_name("Ferguson")
                                             .avatar("https://reqres.in/img/faces/8-image.jpg").build(),
                                        Datum.builder()
                                             .id(9)
                                             .email("tobias.funke@reqres.in")
                                             .first_name("Tobias")
                                             .last_name("Funke")
                                             .avatar("https://reqres.in/img/faces/9-image.jpg").build(),
                                        Datum.builder()
                                             .id(10)
                                             .email("byron.fields@reqres.in")
                                             .first_name("Byron")
                                             .last_name("Fields")
                                             .avatar("https://reqres.in/img/faces/10-image.jpg").build(),
                                        Datum.builder()
                                             .id(11)
                                             .email("george.edwards@reqres.in")
                                             .first_name("George")
                                             .last_name("Edwards")
                                             .avatar("https://reqres.in/img/faces/11-image.jpg").build(),
                                        Datum.builder()
                                             .id(12)
                                             .email("rachel.howell@reqres.in")
                                             .first_name("Rachel")
                                             .last_name("Howell")
                                             .avatar("https://reqres.in/img/faces/12-image.jpg").build()))
                                .support(Support.builder()
                                                .url("https://reqres.in/#support-heading")
                                                .text("To keep ReqRes free, contributions towards server costs are appreciated!").build()).build();

        Root actualRoot = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                log().ifValidationFails().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                log().ifValidationFails().
                extract().
                body().as(Root.class);

        assertThat(actualRoot).isEqualTo(expectedRoot);
    }
}