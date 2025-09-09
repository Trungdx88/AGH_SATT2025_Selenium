package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    private final By _txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By _txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");


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

    public HomePage ChangePassword(String currentPassword , String newPassword, String confirmPassword ){
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        this.getBntChangePassword().click();
        return new HomePage();
    }
}
