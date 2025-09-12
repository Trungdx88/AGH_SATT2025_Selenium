package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage extends GeneralPage{
    private final By _txtNewPassword = By.id("newPassword");
    private final By _txtConfirmPassword = By.id("confirmPassword");
    private final By _txtResetToken = By.id("resetToken");

    private final By _btnResetPassword = By.xpath("//input[@value='Reset Password']");

    public WebElement getTxtNewPassword(){
        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }
    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    public WebElement getTxtResetToken(){
        return Constant.WEBDRIVER.findElement(_txtResetToken);
    }

    public WebElement getBntResetPassword(){
        return Constant.WEBDRIVER.findElement(_btnResetPassword);
    }

    public HomePage resetPassword(String newPassword , String confirmPassword , String resetToken ){
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtResetToken().sendKeys(resetToken);
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        this.getBntResetPassword().click();
        return new HomePage();
    }
}
