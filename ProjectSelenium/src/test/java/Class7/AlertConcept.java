package Class7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertConcept {

    @Test
    public void handleConcept() {
        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        // Using Alert class
        // 1. switch to Alert
        Alert myAlert = driver.switchTo().alert();

        // getText of alert,
        String alertText = myAlert.getText();

        // click the -ve action button
        myAlert.dismiss();

        // click +ve button
        myAlert.accept();

        // sendKeys
        myAlert.sendKeys("10001");


    }

}
