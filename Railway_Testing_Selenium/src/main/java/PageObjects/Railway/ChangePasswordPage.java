package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    //Locator
    private final By _txtCurrentPassword = By.id("currentPassword");
    private final By _txtNewPassword = By.id("newPassword");
    private final By _txtConfirmPassword = By.id("confirmPassword");
    private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");

    // Elements
    public WebElement getTxtCurrentPassword(){
        return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
    }
    public WebElement getTxtNewPassword(){
        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }
    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getBntChangePassword(){
        return Constant.WEBDRIVER.findElement(_btnChangePassword);
    }

    public void fillChangePasswordInformation(String currentPassword, String newPassword, String confirmPassword) {
        this.getTxtCurrentPassword().clear();
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().clear();
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().clear();
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
    }

    public void submitChangePassword() {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        this.getBntChangePassword().click();
    }

    public HomePage ChangePassword(String currentPassword, String newPassword, String confirmPassword) {
        fillChangePasswordInformation(currentPassword, newPassword, confirmPassword);
        submitChangePassword();
        return new HomePage();
    }

}
