package Pages.GetRequests;

import Pages.Endpoints.Endpoints;
import Pages.IDs.IDs;
import Pages.RequestSpecifcation.RequestSpecifcationClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetCard {

    public void card()
    {
       given()
               .spec(RequestSpecifcationClass.request)
               .pathParam(
                       "id" , IDs.cardID
               )
       .when()
               .get(Endpoints.getCard)
       .then()
               .log().all()
               .statusCode(200)
               .assertThat().body(
                       "id" , is(equalTo(IDs.cardID))
               );
    }
}
