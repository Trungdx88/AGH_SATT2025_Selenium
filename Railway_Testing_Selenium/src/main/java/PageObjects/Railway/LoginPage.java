package PageObjects.Railway;

import Common.Constant.Constant;
import DataObject.model.enums.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    // Locators
    private final By _txtUsername = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.xpath("//input[@value='login']");

    // Elements
    public WebElement getTxtUsername() {return Constant.WEBDRIVER.findElement(_txtUsername);}
    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getBtnLogin() {return Constant.WEBDRIVER.findElement(_btnLogin);}

    public void fillLoginInformation(User user) {
        getTxtUsername().clear();
        getTxtUsername().sendKeys(user.getUsername());
        getTxtPassword().clear();
        getTxtPassword().sendKeys(user.getPassword());
    }
    public void submitLoginInformation(User user) {
        fillLoginInformation(user);
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", getBtnLogin());
        getBtnLogin().click();
    }

    public HomePage login(User user) {
        submitLoginInformation(user);
        waitForLoginButtonNotDisplay();
        return new HomePage();
    }
    public void waitForLoginButtonNotDisplay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
