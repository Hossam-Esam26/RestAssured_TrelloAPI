package Pages.CreateRequests;

import Pages.Endpoints.Endpoints;
import Pages.IDs.IDs;
import Pages.RequestSpecifcation.RequestSpecifcationClass;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class CreateBoard {

    public void createBoard()
    {
        String boardName = "RestAssured";

        Response response =
        given()
                .spec(RequestSpecifcationClass.request)
                .queryParam("name" , boardName)
        .when()
                .post(Endpoints.createBoard)
        .then()
                .log().all()
                .statusCode(200)
                .assertThat().body(
                        "id" , is(notNullValue()),
                "name" , is(equalTo("RestAssured")),
                      "prefs.switcherViews[0].enabled" , is(true)
                )
                .extract()
                .response();

        IDs.boardID = response.jsonPath().getString("id");
    }
}
