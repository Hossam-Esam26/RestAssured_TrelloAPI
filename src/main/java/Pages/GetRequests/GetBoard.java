package Pages.GetRequests;

import Pages.Endpoints.Endpoints;
import Pages.IDs.IDs;
import Pages.RequestSpecifcation.RequestSpecifcationClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetBoard {

    public void board()
    {
        given()
                .spec(RequestSpecifcationClass.request)
                .pathParam(
                        "id" , IDs.boardID
                )
        .when()
                .get(Endpoints.getBoard)
        .then()
                .log().all()
                .statusCode(200)
                .assertThat().body(
                        "id" , is(equalTo(IDs.boardID)),
                "name" , is(notNullValue())
                );
    }
}
