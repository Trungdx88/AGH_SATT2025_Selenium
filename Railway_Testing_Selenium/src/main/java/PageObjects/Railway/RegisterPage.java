package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    //Locator
    private final By _txtEmail = By.id("email");
    private final By _txtPassword = By.id("password");
    private final By _txtConfirmPassword = By.id("confirmPassword");
    private final By _txtPid = By.id("pid");
    private final By _btnRegister = By.xpath("//input[@value='Register']");

    // Elements
    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getTxtPid(){
        return Constant.WEBDRIVER.findElement(_txtPid);
    }
    public WebElement getBntRegister(){
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    public void fillRegisterInformation(String email, String password, String confirmPassword, String pid) {
        getTxtEmail().clear();
        getTxtEmail().sendKeys(email);

        getTxtPassword().clear();
        getTxtPassword().sendKeys(password);

        getTxtConfirmPassword().clear();
        getTxtConfirmPassword().sendKeys(confirmPassword);

        getTxtPid().clear();
        getTxtPid().sendKeys(pid);
    }

    public void submitRegisterInformation() {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        getBntRegister().click();
    }

    public HomePage register(String email, String password, String confirmPassword, String pid) {
        fillRegisterInformation(email, password, confirmPassword, pid);
        submitRegisterInformation();
        return new HomePage();
    }
}
