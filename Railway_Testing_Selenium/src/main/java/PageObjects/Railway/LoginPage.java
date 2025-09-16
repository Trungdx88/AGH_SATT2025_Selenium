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

    public HomePage login(User user){
        this.getTxtUsername().sendKeys(user.getUsername());
        this.getTxtPassword().sendKeys(user.getPassword());
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        this.getBtnLogin().click();
        return new HomePage();
    }
}
