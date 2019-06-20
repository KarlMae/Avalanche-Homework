package ee.karl.spring.cucumber.steps;

import cucumber.api.java.en.And;
import ee.karl.spring.cucumber.pageobjects.calculator.CalculatorPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StepsCalculatorPage extends ParentSteps {

    private static final Logger logger = LoggerFactory.getLogger(StepsCalculatorPage.class);
    private CalculatorPage homePage;

    @Given("^I am on the calculator page")
    public void i_am_on_the_calculator_page() throws Throwable {
        webdriver.get("http://localhost:3000");
        homePage = new CalculatorPage(webdriver);
    }

    @Given("^I enter \"([^\"]*)\" as number 1$")
    public void i_enter_number_1(String number) throws Throwable {
        homePage.inputNumber1(number);
    }

    @Given("^I enter \"([^\"]*)\" as number 2$")
    public void i_enter_number_2(String number) throws Throwable {
        homePage.inputNumber2(number);
    }

    @When("^I press the calculate button$")
    public void i_press_the_search_button() throws Throwable {
        homePage.clickCalculateButton();
    }

    @When("^I press the history button$")
    public void i_press_the_history_button() throws Throwable {
        homePage.clickHistoryButton();
    }

    @And("^I press the \"([^\"]*)\" operation button$")
    public void i_press_the_operation_button(String operationName) throws Throwable {
        homePage.clickOperationButton(operationName);
    }

    @Then("^I should see \"([^\"]*)\" as output$")
    public void i_should_see_output(String output) throws Throwable {
        String result = homePage.getResult();
        Assert.assertEquals(output, result);
    }

    @Then("^I should see the modal")
    public void i_should_see_the_modal() throws Throwable {
        Boolean isModalVisible = homePage.isModalVisible();
        Assert.assertEquals(true, isModalVisible);
    }

    @Then("^I should not see the modal")
    public void i_should_not_see_the_modal() throws Throwable {
        Assert.assertEquals(0, webdriver.findElements(By.xpath("/html/body/div[2]/div[3]")).size());
    }

    @Then("^History modal should have results")
    public void history_modal_should_have_results() throws Throwable {
        Assert.assertNotEquals(0,
                webdriver.findElements(By.xpath("/html/body/div[2]/div[3]/div/div/table/tbody/tr[1]")).size());
    }

    @Then("^Last item in the table should be \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" ,\"([^\"]*)\"$")
    public void i_should_see_output(String operation, String number1, String number2, String result) throws Throwable {
        List<String> rowValues = homePage.getLastRowValues();
        Assert.assertEquals(operation, rowValues.get(0));
        Assert.assertEquals(number1, rowValues.get(1));
        Assert.assertEquals(number2, rowValues.get(2));
        Assert.assertEquals(result, rowValues.get(3));
    }
}
