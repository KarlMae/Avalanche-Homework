package ee.karl.spring.cucumber.pageobjects.calculator;

import ee.karl.spring.cucumber.pageobjects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatorPage extends PageObject {

	@FindBy(xpath = "//*[@id=\"outlined-simple-start-adornment\"]")
	private List<WebElement> numberFields;

	@FindBy(xpath="//span[text()='Calculate']")
	private WebElement calculateButton;

    @FindBy(xpath="//span[text()='Calculator history']")
    private WebElement historyButton;

	@FindBy(xpath="//div[@class='modal']")
    private WebElement modal;

	@FindBy(xpath="//tbody/tr[last()]/*")
    private List<WebElement> tableRows;

	public CalculatorPage(WebDriver driver) {
		super(driver);
	}
	
	public void inputNumber1(String textToSearch) {
        numberFields.get(0).sendKeys(textToSearch);
	}

    public void inputNumber2(String textToSearch) {
        numberFields.get(1).sendKeys(textToSearch);
    }

    public void clickCalculateButton() {
        calculateButton.click();
	}

    public void clickHistoryButton() {
        historyButton.click();
    }

    public void clickOperationButton(String operationName) {
        webdriver.findElement(
                By.xpath(String.format("//input[@type='radio' and @value='%s']", operationName)))
                        .click();
    }

	public String getResult() {
        return numberFields.get(2).getAttribute("value");
    }

    public boolean isModalVisible() {
	    return modal.isDisplayed();
    }

    public List<String> getLastRowValues() {
	    return tableRows.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
