package hellocucumber.stepdefinitions;

import java.time.LocalDate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import hellocucumber.payloads.*;
import hellocucumber.requests.*;

public class BookingReportsStepDefs {

    @Given("ユーザーが予約ページにアクセスしている")
    public void i_have_multiple_bookings() {
        System.out.println("Given ユーザーが予約ページにアクセスしている");
        BookingDates dates = new BookingDates(
            LocalDate.of(2021,01,01),
            LocalDate.of(2021,03,31)
        );
        Booking payloadOne =new Booking(
            "スズキ",
            "一郎",
            200,
            true,
            dates,
            "breakfast"
        );

        Booking payloadTwo = new Booking(
            "田中",
            "次郎",
            400,
            true,
            dates,
            "No coffee"
        );

        BookingApi.postBooking(payloadOne);
        BookingApi.postBooking(payloadTwo);
    };

    @When("ユーザーが予約情報を入力する")
    public void i_ask_for_a_report_on_my_total_earnings() {
        System.out.println("When ユーザーが予約情報を入力する");
        throw new io.cucumber.java.PendingException();
    }

    @Then("予約が成功することを確認する")
    public void i_will_receive_a_total_amount_based_on_all_my_bookigs() {
        System.out.println("Then 予約が成功することを確認する");
        throw new io.cucumber.java.PendingException();
    }
}
