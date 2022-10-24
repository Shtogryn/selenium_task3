package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(xpath = "//div[@id='passwordNext']")
    WebElement buttonNext;

    public PasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submitPassword(String password) {
        passwordField.sendKeys(password);
        buttonNext.click();
    }
}
