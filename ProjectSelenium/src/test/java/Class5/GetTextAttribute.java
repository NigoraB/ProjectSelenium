package Class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetTextAttribute {

    @Test
    public void getTextTest() {

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/reg/");

        // getText
        By signUpLocator = By.name("websubmit");
        WebElement signupButton = driver.findElement(signUpLocator);
        String buttonText = signupButton.getText();     // Sign Up
        // verify text on sign up button is 'Sign Up'
        Assert.assertEquals(buttonText, "Sign Up", "Button text is not as expected");
    }

    @Test
    public void getAttributeTest() {

        // verify user lands on correct page after clicking 'Create a page' link

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        // getAttribute -> it will return the value of a given attribute in the webElement
        By capLocator = By.linkText("Create a Page");
        WebElement capLink = driver.findElement(capLocator);
        String newPageUrl = capLink.getAttribute("href");

        capLink.click();

        String actualNewUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualNewUrl, newPageUrl, "user lands on different page than expected");

    }
}
