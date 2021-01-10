package Class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicDriverMethods {
    public static void main(String[] args) {

        // code to provide location of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        // code to provide location of firefoxdriver
        // System.setProperty("webdriver.gecko.driver", "path-of-firefox-driver");


        WebDriver driver = new ChromeDriver();
        // WebDriver driver = new FirefoxDriver();

        // WebDriver driver = new WebDriver(); <- cannot create object of an interface.

        /**
         * new ChromeDriver(); -> creating an object of ChromeDriver class
         * WebDriver driver -> creating a variable (named, driver) of WebDriver datatype.
         *
         * String the object of ChromeDriver in WebDriver variable (driver).
         *
         *
         * ChromeDriver(C) --> RemoteWebDriver(C) --> implements WebDriver(I)
         */

        /**
         * WebDriver driver = new ChromeDriver();
         *
         * will create a blank default/basic chrome browser window (factory setting)
         *      the window will have a unique windowHandle
         *      this windowHandle is going to be stored in driver variable.
         *
         * Now, using the driver whatever action I will do,
         *      it will be performed on chromeWindow launched by automation.
         *
         */

        /**
         * To launch a specific webpage
         * 1. get()
         * 2. navigate.to()
         */
        driver.get("https://www.facebook.com");
        // execute command to launch facebook.com
        // wait for few seconds for webpage to load
        // then proceed to next command
        //  -- OR --
        // driver.navigate().to("https://www.facebook.com");
        // execute command to launch facebook.com
        // then proceed to next command

        /**
         * get() vs navigate.to()
         * -> after entering command to launch webpage, get() waits for few seconds for website load,
         *      whereas navigate.to() does not wait at all.
         */

        /**
         * method to maximize the window
         */
        driver.manage().window().maximize();

        /**
         * method to get the page title
         */
        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);

        /**
         * method to get current url
         */
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current url: " + currentUrl);

        /**
         * Ways to refresh a webpage
         */
        // 1
        driver.navigate().refresh();

        // 2
        String myUrl = driver.getCurrentUrl();
        driver.get(myUrl);
        // driver.get(driver.getCurrentUrl());

        // 3
        // navigate.back() <- go back
        // navigate.forward() <- go forward
        driver.navigate().back();
        driver.navigate().forward();

        /**
         * Method to close webpage
         * 1. close() : closes the current instance of web-browser
         *              In other words, if multiple windows are opened bcz of automation
         *              then close() will close the window associated with driver.
         * 2. quit()  : closes ALL instances of web-browser opened bcz of automation
         */
        // driver.close();
        driver.quit();



    }
}
