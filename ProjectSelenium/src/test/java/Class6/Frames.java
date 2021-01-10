package Class6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Frames {

    @Test
    public void countFrames() {

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com");

        By framesLocator = By.tagName("iframe");
        List<WebElement> allFrames = driver.findElements(framesLocator);
        System.out.println("Frames count" + allFrames.size());
    }

    public void switchToFrame() {
        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com");

        // using id
        driver.switchTo().frame("darla_csc_writer_1");

        // using frameWebElement
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='darla']"));
        driver.switchTo().frame(frameElement);

        // using index
        driver.switchTo().frame(2);



        // to switch back to main browser window
        driver.switchTo().defaultContent();





    }

}
