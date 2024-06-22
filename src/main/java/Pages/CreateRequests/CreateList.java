package Pages.CreateRequests;

import Pages.Endpoints.Endpoints;
import Pages.IDs.IDs;
import Pages.RequestSpecifcation.RequestSpecifcationClass;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class CreateList {

    public void createList()
    {
        String listName = "test";

        Response response=
                given()
                        .spec(RequestSpecifcationClass.request)
                        .queryParams(
                                "name" , listName,
                                "idBoard" , IDs.boardID
                        )
                .when()
                        .post(Endpoints.creareList)
                .then()
                        .log().all()
                        .statusCode(200)
                        .assertThat().body(
                                "id" , is(notNullValue()),
                        "name" , is(equalTo(listName)),
                        "idBoard" , is(notNullValue())
                        )
                        .extract().response();

        IDs.listID = response.jsonPath().getString("id");
    }
}
