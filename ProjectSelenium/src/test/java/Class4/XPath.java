package Class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        /**
         * Xpath: is an XML path.
         *        is a direction/map provided to driver to locate the webelement.
         *
         *  Types:
         *      1. Absolute (like google maps)
         *          - give direction from root node.
         *          - it starts with single slash (/)
         *          - Why not to use? - any change in webpage, can change the absolute xpath.
         *      2. Relative (like directions we give in real life)
         *          - it starts with double slash (//)
         *
         */

        /**
         *
         *
         * <tag attr1="value1" attr2="value2" attr3 attr4="value4">
         *      <tag id="abcd" attr1 attr3="value3">
         *          <tag attr1="val1" attr3> inner text value</tag>
         *          Any Text Value
         *      </tag>
         *      <tag attr1 attr3="value3">
         *          Text Value
         *      </tag>
         *      <tag attr1="value one" attr3="value3">
         *          Some Text Value
         *      </tag>
         * </tag>
         *
         * <tag>Text Value</tag>
         */

        /**
         * Using attribute value
         * //tagName[@attr='attr-value']
         *
         * Find the tag(tagName) where attribute(attr) has value=attr-value
         */

        String emailXpath = "//input[@data-testid='royal_email']";

        // For Interview: how to use double-quotes in xpath instead single-quotes.
        // String emailXpath1 = "//input[@data-testid=\"royal_email\"]";

        By emailLocator = By.xpath(emailXpath);
        WebElement emailElement = driver.findElement(emailLocator);
        emailElement.sendKeys("test@email.com");

        /**
         * Using text
         * //tagName[text()='text value']
         *
         * Find the tag(tagName) where text is equal to 'text value'
         */
        // String createPageXpath = "//a[text()='Create a Page']";
        // By createPageLocator = By.xpath(createPageXpath);
        By createPageLocator = By.xpath("//a[text()='Create a Page']");
        WebElement createPageElement = driver.findElement(createPageLocator);
        createPageElement.click();

        /**
         * contains
         * Using attribute value:
         * //tagName[contains(@attr, 'attr-val')]
         *
         * Using text
         * //tagName[contains(text(), 'text val')]
         *
         * not()
         * Using attribute value:
         * //tagName[not(contains(@attr, 'attr-val'))]
         * //tagName[not(@attr,'attr-value')]
         *
         * Using text
         * //tagName[not(text(), 'text val')]
         *
         */
        // to locate ALL DATES from second calender in hotels.com
        // (//div[@class='widget-datepicker-bd'])[2]//td[not(contains(@class,'datepicker-empty'))]//a
        // (//div[@class='widget-datepicker-bd'])[2]//td[@data-date]//a
        // //td[contains(@data-date, '2020-')]//a
        // //td[starts-with(@data-date, '2020-')]//a

        /**
         * starts-with()
         *
         * Using attribute value
         * //tagName[starts-with(@attr, 'attr-v')]
         *
         * Using text
         * //tagName[starts-with(text(), 'Text Va')]
         */
        By votingLinkLocator = By.xpath("//a[starts-with(text(), 'Voting Inf')]");
        WebElement votingLinkElement = driver.findElement(votingLinkLocator);
        votingLinkElement.click();

        /**
         * and / or
         *
         * //tagName[@attr='attr-value' and contains(text(), 'ple Tex')]       // Suppose: text = 'Sample Text'
         *
         * //tagName[(contains(text(),'ple Te') and starts-with(@attr='attr-v')) or (@attr1='attrtbute1 value')]
         */

        /**
         * Indirect xPath
         *
         * // to locate ALL DATES from second calender in hotels.com
         * (//div[@class='widget-datepicker-bd'])[2]//td[not(contains(@class,'datepicker-empty'))]//a
         * (//div[@class='widget-datepicker-bd'])[2]//td[@data-date]//a
         * //td[contains(@data-date, '2020-')]//a
         * //td[starts-with(@data-date, '2020-')]//a
         */

        /**
         * In direct xPath
         *
         *
         * <tag1 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
         *     <tag1_1 id="abcd" data-text-id="unique data" attr3="value3" attr4="value4">     //tag[@data-text-id='unique data']/tag[text()='No Unique Text']/subTag[@attr='value1']
         *                                                                                  //tag[@data-text-id='unique data']//subTag[@attr='value1']
         *         <tag1_1_1>Not Unique Text
         *              <subTag attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag1>
         *         </tag1_1_1>
         *         <tag1_1_2 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag1_1_2>
         *              <subTag1 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</subTag1>
         *
         *              //subTag1[text()='Unique Text']/following-sibling::subTag2[@attr1='value1']
         *
         *              <subTag2 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</subTag2>
         *                  <subTag3 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</subTag3>
         *         <tag1_1_3 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag1_1_3>
         *     </tag1_1>
         *     <tag1_2 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
         *         <tag1_2_1 attr1="value1" attr2="value2">Unique Text</tag>
         *     </tag1_2>
         *     <tag1_3 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
         *          <tag1_3_1 attr1="value1" attr2="value2" attr3="value3" attr4="value4"></tag>
         *     </tag1_3>
         * </tag1>
         *
         * descendants of from tag1 to reach to subTag3
         *      tag1_1, tag1_1_2, subTag2, subTag3 (gp, p, y, yc)
         * following of tag1_1_2
         *      subTag1, subTag2, subTag3, tag1_1_3, tag1_2, tag1_2_1, tag1_3, tag1_3_1
         *
         * ancestor of subTag3
         *      subTag2, tag1_1_2, tag1_1, tag1
         * preceding of subTag3
         *      subTag2, subTag1, tag1_1_2, tag1_1_1, tag1_1, tag1
         *
         * following-sibling
         * preceding-sibling
         *
         *
         */

        /**
         * xPath axes
         * 1. following
         * 2. descendant
         * 3. preceding
         * 4. ancestor
         * 5. following-sibling
         * 6. preceding-sibling
         *
         * 7. parent
         * 8. child
         * 9. self
         *
         */

        /**
         * following
         * //tagName[text()='text value']//following::tagName2[condition(s)]
         *
         * eg: //div[@id='reg_form_box']//following::button
         */

        /**
         * descendant
         * //tagName[text()='text value']//descendant::tagName2[condition(s)]
         *
         * eg: //div[@id='reg_form_box']//descendant::button
         */

        /**
         * preceding
         * //tagName[condition(s)]//preceding::tagName2[condition(s)]
         */

        /**
         * ancestor
         * //tagName[condition(s)]//ancestor::tagName2[condition(s)]
         */

        /**
         * following-sibling
         * //tagName[condition(s)]//following-sibling::tagName2[condition(s)]
         * 
         * eg:
         * //div[starts-with(text(),'Mobile number')]/following-sibling::input
         */

        /**
         * preceding-sibling
         * //tagName[condition(s)]//preceding-sibling::tagName2[condition(s)]
         *
         * eg:
         * //label[text()='Male']//preceding-sibling::input
         */


        String gender = "Custom";

        String genderRadioButtonXpath = "//label[text()='" + gender + "']//preceding-sibling::input";
        String femaleRadioButtonXpath = "//label[text()='Female']//preceding-sibling::input";
        String customRadioButtonXpath = "//label[text()='Custom']//preceding-sibling::input";


        By maleRadioLocator = By.xpath(genderRadioButtonXpath);
        WebElement maleRadioButton = driver.findElement(maleRadioLocator);
        maleRadioButton.click();


        By abc = By.xpath("//label[text()='" + gender + "']//preceding-sibling::input");
        By femaleRadioLocator = By.xpath(femaleRadioButtonXpath);
        WebElement femaleRadioButton = driver.findElement(femaleRadioLocator);
        femaleRadioButton.click();




    }
}
