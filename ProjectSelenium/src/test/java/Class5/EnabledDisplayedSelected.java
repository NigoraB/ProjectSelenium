package Class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnabledDisplayedSelected {

    @Test   // annotation from testng
    public void onlyFemaleRadioIsSelected() {

        // Verify only female radio button is selected by default.

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/reg/");

        /**
         * isSelected()
         * return type: boolean
         */
        By femaleRadioButtonLocator = By.xpath("//label[text()='Female']//preceding-sibling::input");
        By maleRadioButtonLocator = By.xpath("//label[text()='Male']//preceding-sibling::input");
        By customRadioButtonLocator = By.xpath("//label[text()='Custom']//preceding-sibling::input");

        WebElement femaleRadioElement = driver.findElement(femaleRadioButtonLocator);
        boolean isFemaleButtonSelected = femaleRadioElement.isSelected();

        WebElement maleRadioElement = driver.findElement(maleRadioButtonLocator);
        boolean isMaleButtonSelected = maleRadioElement.isSelected();

        WebElement customRadioElement = driver.findElement(customRadioButtonLocator);
        boolean isCustomButtonSelected = customRadioElement.isSelected();

        /*if (isFemaleButtonSelected && !isMaleButtonSelected && !isCustomButtonSelected) {
            System.out.println("No radio button is selected.");
        } else {
            System.out.println("One or more radio button is selected");
        }*/

        // Assert (from testNG)
        Assert.assertTrue(isFemaleButtonSelected && !isMaleButtonSelected && !isCustomButtonSelected,
                "Male or Custom radio button is selected");
    }

    @Test   // annotation from testng
    public void noRadioIsSelected() {

        // Verify no radio button is selected by default.

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/reg/");

        /**
         * isSelected()
         * return type: boolean
         */
        By femaleRadioButtonLocator = By.xpath("//label[text()='Female']//preceding-sibling::input");
        By maleRadioButtonLocator = By.xpath("//label[text()='Male']//preceding-sibling::input");
        By customRadioButtonLocator = By.xpath("//label[text()='Custom']//preceding-sibling::input");

        WebElement femaleRadioElement = driver.findElement(femaleRadioButtonLocator);
        boolean isFemaleButtonSelected = femaleRadioElement.isSelected();

        WebElement maleRadioElement = driver.findElement(maleRadioButtonLocator);
        boolean isMaleButtonSelected = maleRadioElement.isSelected();

        WebElement customRadioElement = driver.findElement(customRadioButtonLocator);
        boolean isCustomButtonSelected = customRadioElement.isSelected();

        /*if (isFemaleButtonSelected && !isMaleButtonSelected && !isCustomButtonSelected) {
            System.out.println("No radio button is selected.");
        } else {
            System.out.println("One or more radio button is selected");
        }*/

        // Assert (from testNG)
        Assert.assertTrue(!isFemaleButtonSelected && !isMaleButtonSelected && !isCustomButtonSelected,
                "One or more radio button is selected");
    }


    @Test   // annotation from testng
    public void signUpButtonEnabled() {

        // Verify sign up button is active/enabled

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/reg/");

        /**
         * isEnabled()
         * return type: boolean
         */

        By signUpLocator = By.name("websubmit");
        WebElement signupButton = driver.findElement(signUpLocator);
        boolean isSignupButtonEnabled = signupButton.isEnabled();
        Assert.assertTrue(isSignupButtonEnabled, "Sign up button is not enabled");
        driver.quit();

    }

    @Test   // annotation from testng
    public void errorDisplayed() {

        // Verify user see error msg when submits blank form

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/reg/");

        /**
         * isDisplayed()
         * return type: boolean
         */

        By signUpLocator = By.name("websubmit");
        WebElement signupButton = driver.findElement(signUpLocator);
        signupButton.click();
        // code
        driver.quit();
    }

}
