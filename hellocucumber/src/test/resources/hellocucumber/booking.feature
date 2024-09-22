Feature: Booking Feature

  Scenario: Successful booking
    Given ユーザーが予約ページにアクセスしている
    When ユーザーが予約情報を入力する
    Then 予約が成功することを確認する
