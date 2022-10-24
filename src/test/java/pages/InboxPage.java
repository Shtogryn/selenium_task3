package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
    @FindBy(xpath = "//div[text()='Compose']")
    WebElement buttonCompose;
    @FindBy(xpath = "//form[@class='bAs']//textarea[@name='to']")
    WebElement textAreaTo;
    @FindBy(xpath = "//form/div/input[@name='subjectbox']")
    WebElement subjectbox;
    @FindBy(xpath = "//div[@class='AD']//td/div/div[@role='textbox']")
    WebElement messageTextArea;
    @FindBy(xpath = "//div[@class='AD']//tr[@class='btC']/td/div/div[@role='button']")
    WebElement sendButtom;

    public InboxPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void sendMessage(String message, String email, String purpose) {
        buttonCompose.click();
        textAreaTo.sendKeys(email);
        subjectbox.sendKeys(purpose);
        messageTextArea.sendKeys(message);
        sendButtom.click();
    }
}
