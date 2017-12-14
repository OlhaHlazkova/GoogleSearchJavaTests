import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import com.thoughtworks.selenium.Selenium;*/

public class SeleniumIDESearchTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {

      System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");

    driver = new FirefoxDriver();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSeleniumIDESearch() throws Exception {
    driver.get("https://www.google.com.ua/");
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("selenium ide");
    driver.findElement(By.name("btnK")).click();
    assertTrue(isElementPresent(By.linkText("Selenium IDE Plugins")));
    driver.findElement(By.linkText("Selenium IDE Plugins")).click();
    assertEquals(driver.getCurrentUrl(), "http://www.seleniumhq.org/projects/ide/");
    driver.findElement(By.linkText("Selenium IDE Plugins")).click();
    assertEquals(driver.getCurrentUrl(), "http://www.seleniumhq.org/projects/ide/plugins.jsp");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
