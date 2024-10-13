package hellocucumber.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import hellocucumber.payloads.Booking;
import hellocucumber.payloads.BookingDates;
import hellocucumber.payloads.Total;
import hellocucumber.requests.BookingApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

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

        Booking payloadOne =new Booking(
            1,
            "スズキ",
            "一郎",
            "abc@example.com",
            "09012345678",
            true,
            dates,
            "breakfast"
        );

        Booking payloadTwo = new Booking(
            2,
            "田中",
            "次郎",
            "xyz@ab.com",
            "1234567890",
            true,
            dates,
            "No coffee"
        );

        BookingApi.postBooking(payloadOne);
        BookingApi.postBooking(payloadTwo);
    };

    private Response totalResponse;
    @When("ユーザーが予約情報を入力する")
    public void i_ask_for_a_report_on_my_total_earnings() {
        System.out.println("When ユーザーが予約情報を入力する");
        totalResponse = hellocucumber.requests.BookingApi.getTotal();
        System.out.println(totalResponse.toString());
    }

    @Then("予約が成功することを確認する")
    public void i_will_receive_a_total_amount_based_on_all_my_bookigs() {
        System.out.println("Then 予約が成功することを確認する");
        int total = totalResponse.as(Total.class).getTotal();
        System.out.println(total);
        assertEquals(total, 600);
>>>>>>> 49c9c61b90dcceed38e554a0b44a6ff2e3598e32
    }
}
