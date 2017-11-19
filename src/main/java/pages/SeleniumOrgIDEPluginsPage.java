package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Olya on 11/19/2017.
 */
public class SeleniumOrgIDEPluginsPage {
    WebDriver driver;

    String pageUrl = "http://www.seleniumhq.org/projects/ide/plugins.jsp";

    public SeleniumOrgIDEPluginsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCurrentURLCorrect () {
        return driver.getCurrentUrl().equals(pageUrl);
    }
}
