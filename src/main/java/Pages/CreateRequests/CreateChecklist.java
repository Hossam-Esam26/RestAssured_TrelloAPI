package Pages.CreateRequests;

import Pages.Endpoints.Endpoints;
import Pages.IDs.IDs;
import Pages.RequestSpecifcation.RequestSpecifcationClass;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateChecklist {

    public void createChecklist()
    {
        String checklistName = "H&M";

        for (int i = 0 ; i < 2 ; i++)
        {
            given()
                    .spec(RequestSpecifcationClass.request)
                    .queryParams(
                            "idCard" , IDs.cardID,
                            "name" , checklistName
                    )
                    .when()
                    .post(Endpoints.createCheckList)
                    .then()
                    .log().all()
                    .statusCode(200)
                    .assertThat().body(
                            "id" , is(notNullValue()),
                            "name" , is(equalTo(checklistName)),
                            "idBoard" , is(equalTo(IDs.boardID)),
                            "idCard" , is(equalTo(IDs.cardID))
                    );
        }
    }
}
