package Tsetcases.Railway;

import Common.Constant.Constant;
import Common.Constant.MessageHelper;
import DataObject.model.enums.enums.MessageType;
import DataObject.model.enums.model.User;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        User user = User.getValidUser();
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        loginPage.login(user);

        String actualMsg = loginPage.getWelcomeMessage();
        MessageType actualEnum = MessageHelper.fromMessage(actualMsg);
        MessageType expectedEnum = MessageType.WELCOME;
        Assert.assertEquals(actualEnum, expectedEnum);
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();

        User user = User.getInvalidUserBlank();
        loginPage.login(user);

        String actualMsg = loginPage.getErrorMessage();
        MessageType actualEnum = MessageHelper.fromMessage(actualMsg);
        MessageType expectedEnum = MessageType.INVALID_LOGIN;
        Assert.assertEquals(actualEnum, expectedEnum);
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();

        User user = User.getInvalidUser();
        loginPage.login(user);

        String actualMsg = loginPage.getErrorMessage();
        MessageType actualEnum = MessageHelper.fromMessage(actualMsg);
        MessageType expectedEnum = MessageType.INVALID_LOGIN;
        Assert.assertEquals(actualEnum, expectedEnum);
    }

    @Test
    public void TC04() {
        System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();

        User user = User.getValidUser();
        loginPage.login(user);
        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        MessageType actualEnum = MessageHelper.fromMessage(bookTicketPage.getPageTitle());
        MessageType expectedEnum = MessageType.BOOKTICKET_TITLE;
        Assert.assertEquals(actualEnum, expectedEnum);
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        for (int i = 0; i < 5; i++) {
            User user = User.getInvalidUser();
            loginPage.login(user);
        }
        String actualMsg = loginPage.getErrorMessage();
        MessageType actualEnum = MessageHelper.fromMessage(actualMsg);
        MessageType expectedEnum = MessageType.ATTEMPT_WARNING;
        Assert.assertEquals(actualEnum, expectedEnum);
    }

    @Test
    public void TC06() {
        System.out.println("TC06 - Additional pages display once user logged in ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();

        User user = User.getValidUser();
        loginPage.login(user);

        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        String actualBookTicketTitle = bookTicketPage.getPageTitle();

        MessageType actualEnumBookTicket = MessageHelper.fromMessage(actualBookTicketTitle);
        MessageType expectedEnumBookTicket = MessageType.BOOKTICKET_TITLE;
        Assert.assertEquals(actualEnumBookTicket, expectedEnumBookTicket);

        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        String actualChangePasswordTitle = changePasswordPage.getPageTitle();

        MessageType actualEnumChangePassword = MessageHelper.fromMessage(actualChangePasswordTitle);
        MessageType expectedEnumChangePassword = MessageType.CHANGEPASSWORD_TITLE;
        Assert.assertEquals(actualEnumChangePassword, expectedEnumChangePassword);
    }
    @Test
    public void TC08() {
        System.out.println("TC08 - User can't login with an account that hasn't been activated");

        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();

        User user = User.getUserActivated();
        loginPage.login(user);

        String actualMsg = loginPage.getErrorMessage();
        MessageType actualEnum = MessageHelper.fromMessage(actualMsg);
        MessageType expectedEnum = MessageType.PASSWORD_MISMATCH;
        Assert.assertEquals(actualEnum, expectedEnum);
    }
}
