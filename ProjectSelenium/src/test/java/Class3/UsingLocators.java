package Class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingLocators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        // Address -> "email"
        // Address Type -> id
        By emailLocator = By.id("email");
        WebElement emailElement = driver.findElement(emailLocator);
        emailElement.sendKeys("invalid");

        By passLocator = By.name("pass");
        WebElement passElement = driver.findElement(passLocator);
        passElement.sendKeys("test1234");

        By forgottenPasswordLocator = By.linkText("Forgotten password?");
        WebElement fpElement = driver.findElement(forgottenPasswordLocator);
        fpElement.click();

        By fpLocator = By.partialLinkText("Forgotten");
        WebElement fpElement_1 = driver.findElement(fpLocator);
        fpElement_1.click();

        By buttonLocator = By.tagName("button");
        WebElement buttonElement = driver.findElement(buttonLocator);
        buttonElement.click();





    }
}
