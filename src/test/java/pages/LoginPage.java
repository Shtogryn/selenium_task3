package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(css = "input[type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//div[@class=\'dG5hZc\']//span")
    private WebElement buttonNext;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submitEmail(String email) {
        emailField.sendKeys(email);
        buttonNext.click();
    }
}
