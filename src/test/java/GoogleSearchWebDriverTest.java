import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleResultPage;
import pages.GoogleStartPage;
import pages.SeleniumOrgIDEPage;
import pages.SeleniumOrgIDEPluginsPage;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Olya on 11/19/2017.
 */
public class GoogleSearchWebDriverTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //firest test
    @Test
    public void testGoogleSearch () {
        GoogleStartPage startPage = new GoogleStartPage(driver);
        GoogleResultPage resultPage = new GoogleResultPage(driver);
        SeleniumOrgIDEPage seleniumOrg = new SeleniumOrgIDEPage(driver);
        SeleniumOrgIDEPluginsPage seleniumOrgIDEPlugins = new SeleniumOrgIDEPluginsPage(driver);

        startPage.openGoogle();
        startPage.typeRequest();
        startPage.clickSearchButton();
        assertTrue(resultPage.isNeededLinkPresent(),"There is no requested link on the page");

        resultPage.clickLinkRequest();
        assertTrue(seleniumOrg.isCurrentURLCorrect());

        seleniumOrg.clickLinkRequest();
        assertTrue(seleniumOrgIDEPlugins.isCurrentURLCorrect());


    }

    @AfterClass
    public  void  tearDown() {
        driver.quit();
    }



}
