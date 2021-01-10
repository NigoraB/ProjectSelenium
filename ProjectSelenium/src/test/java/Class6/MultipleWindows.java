package Class6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    @Test
    public void multipleWindows() {
        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com");

        // how to get windowHandle of the window linked with driver
        // getWindowHandle
        String currentHandle = driver.getWindowHandle();
        System.out.println("Handle: " + currentHandle);

        // how to get windowHandle of all windows(4) launched due to automation
        // getWindowHandles
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All handles: " + allHandles);

        // close all windows except naukri.com
        // to switch/link driver with any browser window (using it's handle)
        // method: switchTo(handle)
        for (String handle : allHandles) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(currentHandle);






    }
}
