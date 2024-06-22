package Pages.GetRequests;

import Pages.Endpoints.Endpoints;
import Pages.IDs.IDs;
import Pages.RequestSpecifcation.RequestSpecifcationClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetList {

    public void list()
    {
        given()
                .spec(RequestSpecifcationClass.request)
                .pathParam(
                        "id" , IDs.listID
                )
        .when()
                .get(Endpoints.getList)
        .then()
                .log().all()
                .statusCode(200)
                .assertThat().body(
                        "id" , is(equalTo(IDs.listID)),
                        "name" , is(notNullValue())
                );
    }
}
