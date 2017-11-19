package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Olya on 11/19/2017.
 */
public class GoogleResultPage {
    private WebDriver driver;

    @FindBy (linkText = "Selenium IDE Plugins")
    private WebElement linkRequest;

    public GoogleResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isNeededLinkPresent () {
        return linkRequest.isDisplayed();
    }

    public void clickLinkRequest () {
        linkRequest.click();
    }
}
