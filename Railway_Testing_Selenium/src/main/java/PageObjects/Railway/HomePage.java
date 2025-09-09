package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage{
    private final By lnkBookTicket = By.linkText("Book ticket");
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
    public BookTicketPage gotoBookTicketPage() {
        Constant.WEBDRIVER.findElement(lnkBookTicket).click();
        return new BookTicketPage();
    }
    public ChangePasswordPage gotoChangePasswordPage() {
        Constant.WEBDRIVER.findElement(By.linkText("Change password")).click();
        return new ChangePasswordPage();
    }
    public RegisterPage gotoRegisterPage() {
        Constant.WEBDRIVER.findElement(By.linkText("Register")).click();
        return new RegisterPage();
    }
}
