package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InboxPage;
import pages.LoginPage;
import pages.PasswordPage;

public class MainTest {
    WebDriver webDriver;
    WebElement webElement;
    static final String URL = "https://www.gmail.com/";
    static final String EMAIL1 = "tom.shtogryn.2004";
    static final String EMAIL2 = "pavlo.stogryn@gmail.com";
    static final String PASSWORD1 = "Hardasarock2019";
    static String Message = "Hello";

    @BeforeEach
    public void initialSetting() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/user/IdeaProjects/Test_task_2/src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(URL);
    }

    @Test
    public void gmailTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.submitEmail(EMAIL1);
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        PasswordPage passwordPage = new PasswordPage(webDriver);
        passwordPage.submitPassword(PASSWORD1);
        (new WebDriverWait(webDriver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Compose']")));
        InboxPage inboxPage=new InboxPage(webDriver);
        inboxPage.sendMessage(Message, EMAIL2, "Test  message");

    }
}

//
//        @AfterEach
//        public void quitDriver() {
//            webDriver.quit();
//        }


