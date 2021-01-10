package Class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Interactions {

    public void ActionsInteractions() {

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.yahoo.com");

        // Actions
        /**
         * Mousehover -> moveToElement
         * drag and drop -> dragAndDrop
         * right click -> contextClick
         * double click -> doubleClick
         */
        Actions act = new Actions(driver);

        WebElement bellIcon = driver.findElement(By.id(""));
        // mouseHover
        act.moveToElement(bellIcon).perform();
        act.moveToElement(bellIcon).build().perform();
        /**
         * .build().perform() vs .perform()
         *
         * when method is doing only 1 action -> .perform () is enough
         *      [but can also use .build().perform()]
         *
         * when method is doing more than 1 actions -> have to use .build().perform()
         *
         */

        // act.dragAndDrop();

        act.contextClick(bellIcon).build().perform();

        act.keyDown("k").build().perform();



    }


}
