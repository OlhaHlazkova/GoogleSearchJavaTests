package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Olya on 11/19/2017.
 */
public class SeleniumOrgIDEPage {
    private WebDriver driver;

    String pageUrl = "http://www.seleniumhq.org/projects/ide/";

    @FindBy(linkText = "Selenium IDE Plugins")
    private WebElement linkRequest;

    public SeleniumOrgIDEPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCurrentURLCorrect () {
        return driver.getCurrentUrl().equals(pageUrl);
    }

    public void clickLinkRequest () {
        linkRequest.click();
    }
}
