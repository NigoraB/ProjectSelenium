package Class6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdown {

    @Test
    public void dropdown() {
        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/reg/");

        //steps to handle/interact dropdown
        /*
            1. find locator
            2. find element
            3. Create object of Select class
            4. use relevant method to select value
               selectByVisibleText | selectByValue | selectByIndex

         */
        By monthLocator = By.id("month");
        WebElement monthDropdown = driver.findElement(monthLocator);
        Select month = new Select(monthDropdown);
        month.selectByVisibleText("Apr");

        By dayLocator = By.id("day");
        WebElement dayDropdown = driver.findElement(dayLocator);
        Select day = new Select(dayDropdown);
        day.selectByValue("5");

        By yearLocator = By.id("year");
        WebElement yearDropdown = driver.findElement(yearLocator);
        Select year = new Select(yearDropdown);
        year.selectByIndex(2);

    }


}
