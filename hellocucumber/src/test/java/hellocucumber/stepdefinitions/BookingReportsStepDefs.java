package hellocucumber.stepdefinitions;

import java.time.LocalDate;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import hellocucumber.payloads.*;
import hellocucumber.requests.*;

public class BookingReportsStepDefs {

    @Given("ユーザーが予約ページにアクセスしている")
    public void i_access_booking_page() {
        System.out.println("Given ユーザーが予約ページにアクセスしている");
        
    };

    @When("ユーザーが予約情報を入力する")
    public void i_input_booking_info() {
        System.out.println("When ユーザーが予約情報を入力する");

    }

    @Then("予約が成功することを確認する")
    public void i_check_booking_success() {
        System.out.println("Then 予約が成功することを確認する");

        BookingDates dates = new BookingDates(
            LocalDate.of(2024,01,01),
            LocalDate.of(2024,03,31)
        );
        Booking payload = new Booking(
            1,
            "ABC",
            "XYZ",
            "abc@example.com",
            "01234567890",
            true,
            dates,
            "breakfast"
        );
        System.out.println(payload);
        Response bookingResult = BookingApi.postBooking(payload);
        //ステータス確認
        assertEquals(201,bookingResult.getStatusCode());
        System.out.println(bookingResult.asPrettyString());
    }
}
