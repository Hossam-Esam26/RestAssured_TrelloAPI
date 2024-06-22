package Pages.CreateRequests;

import Pages.Endpoints.Endpoints;
import Pages.IDs.IDs;
import Pages.RequestSpecifcation.RequestSpecifcationClass;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class CreateCard {

    public void createCard()
    {
        String  cardName = "Rest";
        Response response =
                given()
                        .spec(RequestSpecifcationClass.request)
                        .queryParams(
                                "name" , cardName,
                                "idList" , IDs.listID
                        )
                .when()
                        .post(Endpoints.createCard)
                .then()
                        .log().all()
                        .statusCode(200)
                        .assertThat().body(
                                "id" , is(notNullValue()),
                         "idBoard" , is(equalTo(IDs.boardID)),
                                  "idList" , is(equalTo(IDs.listID))
                        )
                        .extract().response();
        IDs.cardID = response.jsonPath().getString("id");
    }
}
