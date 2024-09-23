package hellocucumber.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

import hellocucumber.payloads.*;
import hellocucumber.requests.*;
import io.restassured.response.Response;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import static com.github.tomakehurst.wiremock.client.WireMock.*;//WireMock導入


public class BookingApiIT{
    //モック起動
    private static WireMockServer authMock;
    @BeforeAll
    public static void setupMock(){
        //3004番ポートにモックサーバを立てる
        authMock = new WireMockServer(WireMockConfiguration.options().port(3004));
        authMock.start();
    }
    @AfterAll
    public static void killMock(){
        authMock.stop();
    }

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

    // @Test
    // public void deleteBookingReturns202(){
    //     //予約の削除のテスト
    //     //リクエストの結合・パースをする

    //     BookingDates dates = new BookingDates(
    //         LocalDate.of(2021, 2, 1),
    //         LocalDate.of( 2021, 2, 3)
    //     );
    //     Booking payload = new Booking(
    //         1,
    //         "Mark",
    //         "Hunter",
    //         200,
    //         true,
    //         dates,
    //         "a cup of coffee"
    //     );

    //     Response bookingResponse = BookingApi.postBooking(payload);
    //     BookingResponse createBookingResponse = bookingResponse.as(BookingResponse.class);
        
    //     //認証情報を作成
    //     Auth auth  = new Auth("admin", "password");

    //     //認証をとる
    //     Response authResponse = AuthApi.postAuth(auth);//ここがAuthAPIの死活に依存している
    //     String authToken = authResponse.getCookie("token");

    //     Response deleteResponse = BookingApi.deleteBooking(createBookingResponse.getBookingid(), authToken);
    //     assertEquals(202, deleteResponse.getStatusCode());
    // }

    @Test
    public void deleteBookingReturns202WithMocks(){

        //テスト準備
        authMock.stubFor(
            post("/auth/validate")
            .withRequestBody(equalToJson("{\"token\": \"dummytoken\"}"))
            .willReturn(aResponse().withStatus(200))
            .withHeader("Content-Type", "application/json")
            .withBody("{ \"message\": \"Token validated successfully.\" }")
        );


        authMock.stubFor(options(urlEqualTo("/booking"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")));


        //ヘッダ組み立て
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

        //予約情報ポスト
        Response bookingResponse = BookingApi.postBooking(payload);
        BookingResponse createBookingResponse = bookingResponse.as(BookingResponse.class);
        
        //テスト
        //予約情報削除
        Response deleteResponse = BookingApi.deleteBooking(createBookingResponse.getBookingid(), "dummytoken");
        assertEquals(202, deleteResponse.getStatusCode());
    }
}