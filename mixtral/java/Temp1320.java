import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import org.junit.Test;

public class Temp1320 {
    public static void main(String[] args) {
        Temp1320 temp = new Temp1320();
        temp.makeSureLoginIsOk();
    }

    @Test
    public void makeSureLoginIsOk() {
        RestAssured.baseURI = "http://yoururl.com"; // Add your base URL here
        given()
            .auth()
            .preemptive()
            .basic("admin", "123")
        .when()
            .get("/myurl")
        .then()
            .statusCode(200);
    }
}