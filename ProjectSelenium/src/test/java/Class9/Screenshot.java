package Class9;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Screenshot {
    @Test
    public void takeScreenshot() throws InterruptedException {

        // TakesScreenShot - interface
        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.hotels.com");

        Thread.sleep(2000);

        driver.findElement(By.id("widget-query-label-1")).click();

        Thread.sleep(1000);

        // Select checkin date as 2 days from today
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        SimpleDateFormat df = new SimpleDateFormat("d");
        String checkInDate = df.format(cal.getTime());


        driver.findElement(By.id("widget-query-label-1")).click();
        By firstMonthDates = By.xpath("(//div[@class='widget-datepicker-bd'])[1]//td[not(contains(@class,'datepicker-empty'))]//a");
        List<WebElement> allDates = driver.findElements(firstMonthDates);
        for (WebElement date : allDates) {
            if (date.getText().equalsIgnoreCase(checkInDate)) {
                date.click();
                break;
            }
        }

        Thread.sleep(1000);



        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./Screenshots/filename.png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();


    }

}
