package Tsetcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD_INVALID);

        String actualError = loginPage.getErrorMessage();
        String expectedError = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualError, expectedError, "Error message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        HomePage homePageAfterLogin = loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        BookTicketPage bookTicketPage = homePageAfterLogin.gotoBookTicketPage();

        String actualTitle = bookTicketPage.getPageTitle();
        String expectedTitle = "Book ticket";
        Assert.assertEquals(actualTitle, expectedTitle, "Book Ticket page is not displayed as expected");
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD_INVALID);
        loginPage.login(Constant.USERNAME,Constant.PASSWORD_INVALID);
        loginPage.login(Constant.USERNAME,Constant.PASSWORD_INVALID);
        loginPage.login(Constant.USERNAME,Constant.PASSWORD_INVALID);
        loginPage.login(Constant.USERNAME,Constant.PASSWORD_INVALID);

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "Login attempts warning message is not displayed as expected");
    }

    @Test
    public void TC06() {
        System.out.println("TC06 - Additional pages display once user logged in ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        String actualBookTicketTitle = bookTicketPage.getPageTitle();
        String expectedBookTicketTitle = "Book ticket";
        Assert.assertEquals(actualBookTicketTitle, expectedBookTicketTitle,
                "Book Ticket page should be displayed after clicking tab");

        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        String actualChangePasswordTitle = changePasswordPage.getPageTitle();
        String expectedChangePasswordTitle = "Change password";
        Assert.assertEquals(actualChangePasswordTitle, expectedChangePasswordTitle,
                "Change Password page should be displayed after clicking tab");
    }
    @Test
    public void TC08() {
        System.out.println("TC08 - User can't login with an account that hasn't been activated");

        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.UNACTIVATED_EMAIL,Constant.UNACTIVATED_PASSWORD);

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
