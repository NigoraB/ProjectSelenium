package Class9;

public class TestNgAnnotations {
    /**
     * BeforeSuite/AfterSuite
     * BeforeTest/AfterTest
     * BeforeClass/AfterClass
     * BeforeMethod/AfterMethod
     * Test
     */

    /**
     * BeforeSuite  <- to cleanup the previous/code, and to get the latest code
     *      BeforeTest
     *          BeforeClass
     *              BeforeMethod    <- initDriver and open url
     *                          Test
     *              AfterMethod     <- quitDriver
     *              BeforeMethod
     *                          Test
     *              AfterMethod
     *              BeforeMethod
     *                          Test
     *              AfterMethod
     *          AfterClass
     *     AfterTest
     * AfterSuite   <- report generation
     *
     */



}
