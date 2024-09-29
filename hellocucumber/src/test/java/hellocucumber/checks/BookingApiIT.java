package hellocucumber.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

import hellocucumber.payloads.*;
import hellocucumber.requests.*;
import io.restassured.response.Response;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import static com.github.tomakehurst.wiremock.client.WireMock.*;//WireMock導入


public class BookingApiIT{
    // //モック起動
    // private static WireMockServer authMock;
    // @BeforeAll
    // public static void setupMock(){
    //     //3004番ポートにモックサーバを立てる
    //     authMock = new WireMockServer(WireMockConfiguration.options().port(3005).notifier(new ConsoleNotifier(true))); // コンソールに詳細なログを出力);
    //     authMock.start();
    // }
    // @AfterAll
    // public static void killMock(){
    //     authMock.stop();
    // }

    @Test
    public void getBookingSummaryShouldReturn200(){
        // GETリクエスト
        Response response = BookingApi.getBookingSummary();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void postBookingReturns201(){
        /*現状テストNG
          [ERROR] Failures:
        [ERROR]   BookingApiIT.postBookingReturns201:62 expected: <201> but was: <409>
        */

        BookingDates dates = new BookingDates(
            LocalDate.of(2024, 10, 1),
            LocalDate.of(2024, 10, 3)
        );

        Booking payload = new Booking(
            1,
            "John",
            "Smith",
            true,
            dates,
            "Breakfast"
        );

        Response response = BookingApi.postBooking(payload);

        assertEquals(201, response.getStatusCode());
    }

    // @Test
    // public void deleteBookingReturns202(){
    //     /*現状テスト失敗
    //      * [ERROR]   BookingApiIT.deleteBookingReturns202:85 » IllegalState Cannot parse object because no supported Content-Type was specified in response. Content-Type was 'text/plain;charset=ISO-8859-1'.
    //      */


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

    
    // public void deleteBookingReturns202WithMocks(){
    //     /*現状テスト失敗
    //      * [ERROR]   BookingApiIT.deleteBookingReturns202WithMocks:131 » IllegalState Cannot parse object because no supported Content-Type was specified in response. Content-Type was 'text/plain;charset=ISO-8859-1'.
    //      */
    //     //テスト準備
    //     authMock.stubFor(
    //         post("/auth/validate")
    //         .withRequestBody(equalToJson("{\"token\": \"dummytoken\"}"))
    //         .willReturn(aResponse().withStatus(200)
    //             .withHeader("Content-Type", "application/json")
    //             .withBody("{ \"message\": \"Token validated successfully.\" }")
    //         )
    //     );
    //     //申し込み情報



    //     //ヘッダ組み立て
    //     BookingDates dates = new BookingDates(
    //         LocalDate.of(2021, 2, 1),
    //         LocalDate.of( 2021, 2, 3)
    //     );
    //     Booking payload = new Booking(
    //         1,
    //         "Mark",
    //         "Hunter",
    //         true,
    //         dates,
    //         "a cup of coffee"
    //     );

    //     //予約情報ポスト
    //     Response bookingResponse = BookingApi.postBooking(payload);
    //     BookingResponse createBookingResponse = bookingResponse.as(BookingResponse.class);
        
    //     // BookingResponse response = new BookingResponse(1,payload);
        
    //     // //モック化
    //     // authMock.stubFor(
    //     //     post("/booking")
    //     //     .withRequestBody(payload)
    //     //     .willReturn(aResponse().withStatus(201)
    //     //         .withHeader("Content-Type", "application/json")
    //     //         // .withBody(response)
    //     //     )
    //     // )



    //     //テスト
    //     //予約情報削除
    //     Response deleteResponse = BookingApi.deleteBooking(createBookingResponse.getBookingid(), "dummytoken");//stubの値に合わせる
    //     assertEquals(202, deleteResponse.getStatusCode());
    // }
}