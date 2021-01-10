package Class3;

public class DOM_Locator {

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
     * Locator: It's a kind of address using which selenium is able to find webElements.
     * Datatype of Locator is "By".
     *
     * DOM
     *  -> Address using DOM
     *      -> Depending upon the type of Address,
     *          we use specific method from By-class to create Locator
     *              -> use Locator to find WebElement using findElement method
     *                  -> we interact(type, click etc) with WebElement.
     *
     */

    /**
     * Address (Types of Locator):
     *  1. id <- always unique  --> By myLocator = By.id("myId")
     *  2. name                 --> By myLocator = By.name("name value")
     *  3. className            --> By myLocator = By.className("class name")
     *  4. linkText             --> By myLocator = By.linkText("")
     *  5. partialLinkText      --> By myLocator = By.partialLinkText("")
     *  6. tagName              --> By myLocator = By.tagName("tagName")
     *
     *  7. xPath                --> By myLocator = By.xpath("created-xpath")
     *  8. CSS
     */

    /**
     * LinkText:
     *      tag is always 'a'
     *      attribute 'href' has the web-address where user will go after clicking the link.
     */

}
