package ee.karl.spring.cucumber.spring;

import ee.karl.spring.cucumber.beans.ChromeWebDriver;
import ee.karl.spring.cucumber.beans.FirefoxWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ContextConfiguration(classes={PropertiesContext.class})
public class CucumberContext {
	
	@Autowired 
	private String webbrowser;
	
	@Bean(name="webdriver", destroyMethod="close")
	public WebDriver getWebDriver() {
		WebDriver webdriver = null;
		switch (webbrowser) {
			case "firefox":
				webdriver = new FirefoxWebDriver();
				break;
			
			case "chrome":
				webdriver = new ChromeWebDriver();
				break;
		}
		return webdriver; 
	}
	
	@Bean("wait")
	public WebDriverWait getWebDriverWait() {
		return new WebDriverWait(getWebDriver(), 5);
	}

}
