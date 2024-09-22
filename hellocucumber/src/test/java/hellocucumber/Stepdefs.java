package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

//テスト対象クラス
class IsItFriday {
    static String isItFriday(String today) {
        return "Nope";
    }
}
class IsAllStepPassed {
    static String isSenario(String message) {
        return "passes";
    }
}

//ステップ定義
public class Stepdefs {
    private String today;
    private String actualAnswer;
    private String message;

    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);    //Nopeが入る

    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    // exampleシナリオのStep
    @Given("an example scenario")
    public void an_example_scenario() {
        message = "A";
    }
    @When("all step definitions are implemented")
    public void all_step_definitions_are_implemented() {
        actualAnswer = IsAllStepPassed.isSenario(message); //passesが入る
    }
    @Then("the scenario {string}")
    public void the_scenario_passes(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
