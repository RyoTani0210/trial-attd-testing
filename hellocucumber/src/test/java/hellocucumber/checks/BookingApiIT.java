package hellocucumber.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import hellocucumber.payloads.*;
import hellocucumber.requests.*;
import io.restassured.response.Response;

public class BookingApiIT{
    @Test
    public void getBookingSummaryShouldReturn200(){
        // GETリクエスト
        Response response = BookingApi.getBookingSummary();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void postBookingReturns201(){
        BookingDates dates = new BookingDates(
            LocalDate.of(2021, 1, 1),
            LocalDate.of(2021,1,3)
        );

        Booking payload = new Booking(
            1,
            "John",
            "Smith",
            200,
            true,
            dates,
            "Breakfast"
        );

        Response response = BookingApi.postBooking(payload);

        assertEquals(201, response.getStatusCode());
    }

    @Test
    public void deleteBookingReturns202(){
        //予約の削除のテスト
        //リクエストの結合・パースをする

        BookingDates dates = new BookingDates(
            LocalDate.of(2021, 2, 1),
            LocalDate.of( 2021, 2, 3)
        );
        Booking payload = new Booking(
            1,
            "Mark",
            "Hunter",
            200,
            true,
            dates,
            "a cup of coffee"
        );

        Response bookingResponse = BookingApi.postBooking(payload);
        BookingResponse createBookingResponse = bookingResponse.as(BookingResponse.class);
        
        //認証情報を作成
        Auth auth  = new Auth("admin", "password");

        //認証をとる
        Response authResponse = AuthApi.postAuth(auth);
        String authToken = authResponse.getCookie("token");

        Response deleteResponse = BookingApi.deleteBooking(createBookingResponse.getBookingid(), authToken);
        assertEquals(202, deleteResponse.getStatusCode());
    }
}