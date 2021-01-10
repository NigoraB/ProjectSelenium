package Class8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scrolls {

    @Test
    public void scrolls() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.hotels.com");

        /**
         * Scroll
         *
         * type without using sendKeys -> use javascript
         * click without using click method from selenium -> use javascript
         */

        /**
         * scroll by pixel
         * scroll upto a webelement
         * scroll to bottom
         */

        /**
         * scroll by pixel
         */
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,700);");    // scroll downward 200 pixels
        Thread.sleep(500);
        js.executeScript("scrollBy(0,-200);");    // scroll upward 200 pixels

        /**
         * scroll upto a webelement
         */
        WebElement elem = driver.findElement(By.id(""));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);

        /**
         * scroll to bottom
         */
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");


    }

}
