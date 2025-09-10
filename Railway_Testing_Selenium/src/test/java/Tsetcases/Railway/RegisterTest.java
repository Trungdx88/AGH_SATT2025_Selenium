package Tsetcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(Constant.VALID_EMAIL,Constant.VALID_PASSWORD,Constant.VALID_CONFIRM_PASSWORD,Constant.VALID_PID);

        String actualMsg = registerPage.getSuccessMessage();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "Register success message is not displayed as expected");
    }

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account when Confirm Password does not match Password");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(Constant.USERNAME,Constant.PASSWORD,Constant.MISMATCH_CONFIRM_PASSWORD,Constant.VALID_PID);

        String actualMsg = registerPage.getRegisterErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC11() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.register(Constant.USERNAME, "", "", "");

        String actualGeneralMsg = registerPage.getRegisterErrorMessage();
        String expectedGeneralMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualGeneralMsg, expectedGeneralMsg, "General error message is not displayed as expected");

        String actualPasswordMsg = registerPage.getValidPasswordMessage();
        String expectedPasswordMsg = "Invalid password length.";
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "Password error message is not displayed as expected");

        String actualPidMsg = registerPage.getValidPidMessage();
        String expectedPidMsg = "Invalid ID length.";
        Assert.assertEquals(actualPidMsg, expectedPidMsg, "PID error message is not displayed as expected");
    }
}
