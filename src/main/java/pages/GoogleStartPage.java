package pages;

import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Olya on 11/19/2017.
 */
public class GoogleStartPage {

    private WebDriver driver;

    private String baseUrl = "https://www.google.com.ua/";

    @FindBy (id="lst-ib")
    private WebElement searchField;

    //@FindBy (name="btnK")
    @FindBy (css = "span.ds:nth-child(1) > span:nth-child(1) > input:nth-child(1)")
    private WebElement searchButton;

    private String requestText = "selenium ide";

    public GoogleStartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openGoogle () {
        driver.get(baseUrl);
    }

    public void typeRequest () {
        searchField.clear();
        searchField.sendKeys(requestText);
    }

    public void clickSearchButton () {

        searchButton.click();
    }

}

