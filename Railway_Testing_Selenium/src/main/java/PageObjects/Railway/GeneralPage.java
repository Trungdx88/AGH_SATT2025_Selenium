package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locator
    private final By lnkBookTicket = By.linkText("Book ticket");
    private final By pageTitle = By.tagName("h1");
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By lblRegisterSuccessMsg = By.xpath("//h1[@align='center']");
    private final By lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblValidPasswordErrorMsg = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By lblPidError = By.xpath("//label[@for='pid' and @class='validation-error']");
    private final By lblChangePasswordSuccessMsg = By.xpath("//p[@class='message success']");


    // Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getLblErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }
    protected WebElement getlblRegisterSuccessMsg() {
        return Constant.WEBDRIVER.findElement(lblRegisterSuccessMsg);
    }
    protected WebElement getLblRegisterErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblRegisterErrorMsg);
    }
    protected WebElement getlblValidPasswordMsg() {
        return Constant.WEBDRIVER.findElement(lblValidPasswordErrorMsg);
    }
    protected WebElement getlblValidPidMsg() {
        return Constant.WEBDRIVER.findElement(lblPidError);
    }
    protected WebElement getLblChangePasswordSuccessMsg() {return Constant.WEBDRIVER.findElement(lblChangePasswordSuccessMsg);
    }

    // Methods
    public String getPageTitle() {
        return Constant.WEBDRIVER.findElement(pageTitle).getText();
    }
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }
    public String getErrorMessage() {
        return this.getLblErrorMessage().getText();
    }
    public String getSuccessMessage(){
        return this.getlblRegisterSuccessMsg().getText();
    }
    public String getRegisterErrorMessage() {
        return this.getLblRegisterErrorMessage().getText();
    }
    public String getValidPasswordMessage(){
        return this.getlblValidPasswordMsg().getText();
    }
    public String getValidPidMessage(){
        return this.getlblValidPidMsg().getText();
    }
    public String getChangePasswordSuccessMsg() {
        return this.getLblChangePasswordSuccessMsg().getText();
    }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
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
