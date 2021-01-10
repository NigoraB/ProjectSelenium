package Class8;

import com.google.common.base.Function;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Wait_Concept {

    @Test
    public void WaitComplete() {

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.hotels.com");

        /**
         *
         * click() -> 09:59:59
         * findElement() -> 10:00:00
         *      throws NoSuchElementException -> 10:00:01
         *
         * click() -> 09:59:59
         * Thread.sleep(5000) -> 10:00:00 - 10:00:05
         * findElement() -> 10:00:06
         *      throws NoSuchElementException -> 10:00:07
         *
         * click() -> 09:59:59
         * wait for 5-seconds -> 10:00:00 - 10:00:05 (10:00:00-10:00:02)
         * findElement() -> 10:00:06
         *      throws NoSuchElementException -> 10:00:07
         */

        /**
         * If script is not able to find element, throws NoSuchElementException.
         * Wait doesn't allow (or ignore) NoSuchElementException during the wait period.
         */

        /**
         * Types of wait:
         * 1. Implicit
         * 2. Explicit
         * 3. Fluent
         *
         * polling period: 250ms
         *
         * Implicit Wait: (like, changing settings in the driver)
         * Wait for a certain amount of time before throwing NoSuchElementException;
         * and stop waiting as soon element is found.
         *
         * polling period: 250ms
         *
         */

        // driver.findElement(By.id(""));

        System.out.println(new Date());
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // System.out.println(new Date());
        // driver.findElement(By.id("testing"));

        /**
         * Explicit Wait
         * Wait for a certain amount of time until specified condition is met.
         * As soon the condition is met, stop waiting and move ahead
         *
         * polling period: 500ms
         */
        WebDriverWait eWait = new WebDriverWait(driver, 20);
        eWait.until(ExpectedConditions.titleIs("Hotels"));

        eWait.until(ExpectedConditions.and(
                ExpectedConditions.alertIsPresent(),
                ExpectedConditions.urlToBe("https://www.hotels.com")
        ));

        eWait.until(ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(By.id("test")),
                ExpectedConditions.titleContains("Hotels")
        ));

        /**
         * Fluent Wait:
         *
         * Wait for a certain amount of time until the element not found or condition(s) is met.
         * When waiting period is over, throws TimeoutException
         *
         * user can define the polling period
         * user can ignore the specific exceptions during wait period
         * user can put a custom message to display when wait is over
         *
         */
        Wait fWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchElementException.class)
                .withMessage("Element is not found after 30seconds of wait");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id(""));
            }
        });


        // how to use fluent wait with explicit conditions
        // fWait.until(ExpectedConditions.titleIs("hotels"));

    }


}
