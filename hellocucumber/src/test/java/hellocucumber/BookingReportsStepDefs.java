package com.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class BookingReportsStepDefs {

    @Given("ユーザーが予約ページにアクセスしている")
    public void i_have_multiple_bookings() {
        System.out.println("Given ユーザーが予約ページにアクセスしている");
        throw new io.cucumber.java.PendingException();
    }

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
