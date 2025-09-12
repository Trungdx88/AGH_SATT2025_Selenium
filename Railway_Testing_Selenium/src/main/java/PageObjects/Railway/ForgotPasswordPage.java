package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class ForgotPasswordPage extends GeneralPage{
    private final By _txtEmail = By.id("email");
    private final By _btnForgotPassword = By.xpath("//input[@value='Send Instructions']");
    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getBntRegister(){
        return Constant.WEBDRIVER.findElement(_btnForgotPassword);
    }
    public HomePage forgotPassword(String email ){
        this.getTxtEmail().sendKeys(email);

        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        this.getBntRegister().click();

        return new HomePage();
    }
    public ResetPasswordPage openResetPasswordLinkFromEmail(String email) {
        MailHelper mailHelper = new MailHelper(Constant.WEBDRIVER);
        String resetLink = mailHelper.getResetPasswordLink(email);
        Constant.WEBDRIVER.get(resetLink);
        return new ResetPasswordPage();
    }
}
