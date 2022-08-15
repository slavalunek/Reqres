import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import rest.dto.singleResource.Data;
import rest.dto.singleResource.Root;
import rest.dto.singleResource.Support;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetSingleResourceTest {

    @Test
    public void getListResourceTest() {
        Root expectedRoot = Root.builder().
                                data(Data.builder()
                                         .id(2)
                                         .name("fuchsia rose")
                                         .year(2001)
                                         .color("#C74375")
                                         .pantone_value("17-2031").build())
                                .support(Support.builder()
                                                .url("https://reqres.in/#support-heading")
                                                .text("To keep ReqRes free, contributions towards server costs are appreciated!").build()).build();

        Root actualRoot = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                log().ifValidationFails().
        when().
                get("https://reqres.in/api/unknown/2").
        then().
                statusCode(200).
                log().ifValidationFails().
        extract().
                body().as(Root.class);

        assertThat(actualRoot).isEqualTo(expectedRoot);
    }
}