package hellocucumber.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import hellocucumber.payloads.Booking;

public class BookingApi extends BaseApi{
    //ベースURLの宣言
    private static final String apiUrl = baseUrl + "booking/";

    public static Response postBooking(Booking payload){
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl);
    }

    public static Response getTotal() {
        return given().get(apiUrl + "report");
    }
}
