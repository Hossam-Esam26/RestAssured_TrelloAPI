package Pages.DeleteRequests;

import Pages.Endpoints.Endpoints;
import Pages.IDs.IDs;
import Pages.RequestSpecifcation.RequestSpecifcationClass;

import static io.restassured.RestAssured.*;
public class DeleteBoard {

    public void board()
    {
        given()
                .spec(RequestSpecifcationClass.request)
                .pathParam(
                        "id" , IDs.boardID
                )
        .when()
                .delete(Endpoints.deleteBoard)
        .then()
                .log().all()
                .statusCode(200);
    }
}
