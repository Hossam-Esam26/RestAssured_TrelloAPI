package Pages.DeleteRequests;

import Pages.Endpoints.Endpoints;
import Pages.IDs.IDs;
import Pages.RequestSpecifcation.RequestSpecifcationClass;
import static io.restassured.RestAssured.*;

public class DeleteCard {

    public void card()
    {
        given()
                .spec(RequestSpecifcationClass.request)
                .pathParam(
                        "id" , IDs.cardID
                )
        .when()
                .delete(Endpoints.deleteCard)
        .then()
                .log().all()
                .statusCode(200);
    }
}
