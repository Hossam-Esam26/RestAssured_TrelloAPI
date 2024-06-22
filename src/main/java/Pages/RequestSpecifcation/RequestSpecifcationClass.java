package Pages.RequestSpecifcation;

import Pages.Auth.Token_Key;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class RequestSpecifcationClass {
    public static RequestSpecification request =
            given().baseUri("https://api.trello.com")
                    .log().all()
                    .contentType(ContentType.JSON)
                    .queryParams(
                            "token" , Token_Key.token ,
                            "key" , Token_Key.sessionKey
                    );
}
