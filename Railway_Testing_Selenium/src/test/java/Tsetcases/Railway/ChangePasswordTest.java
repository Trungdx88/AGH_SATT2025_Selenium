package Tsetcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
    @Test
    public void TC09_UserCanChangePassword() {
        System.out.println("TC09 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        changePasswordPage.ChangePassword(Constant.PASSWORD,Constant.NEW_PASSWORD,Constant.NEW_PASSWORD);

        String actualMsg = changePasswordPage.getChangePasswordSuccessMsg();
        String expectedMsg = "Your password has been updated";
        Assert.assertEquals(actualMsg, expectedMsg, "Password change message is not displayed as expected");
    }
}
