package Class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Autosuggestions {

    @Test
    public void autoSuggestion() {

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.hotels.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("qf-0q-destination")).sendKeys("rich");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 1. get locator for all suggestions
        By allSuggestionsLocator = By.xpath("//div[@class='autosuggest-category-result']");
        List<WebElement> allSuggestions = driver.findElements(allSuggestionsLocator);

        // 2. take user input, which text they want to select
        String userChoice = "Richmond, California, United States of America";

        // 3. using for-loop and if-loop
        /*
            pick an element
                if element-text matches with user choice
                    click
                    stop
         */
        for (WebElement suggestion : allSuggestions) {
            if (suggestion.getText().equalsIgnoreCase(userChoice)) {
                suggestion.click();
                break;
            }
        }


    }

}
