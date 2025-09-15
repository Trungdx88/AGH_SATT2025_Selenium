package Tsetcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ForgotPasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.ResetPasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest{

    @Test
    public void TC12() {
        System.out.println("Errors display when password reset token is blank");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        ForgotPasswordPage forgotPasswordPage = loginPage.gotoForgotPasswordPage();

        String registeredEmail = Constant.USERNAME;
        forgotPasswordPage.forgotPassword(registeredEmail);

        ResetPasswordPage resetPasswordPage = forgotPasswordPage.openResetPasswordLinkFromEmail(registeredEmail);
        resetPasswordPage.resetPassword(Constant.NEW_PASSWORD, Constant.MISMATCH_CONFIRM_PASSWORD, "");

        String actualTopMsg = resetPasswordPage.getForgotPasswordErrorMessage();
        String expectedTopMsg = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
        Assert.assertEquals(actualTopMsg, expectedTopMsg, "Top error message is not as expected");

        String actualTokenMsg = resetPasswordPage.getValidResetTokenMessage();
        String expectedTokenMsg = "The password reset token is invalid.";
        Assert.assertEquals(actualTokenMsg, expectedTokenMsg, "Token error message is not as expected");
    }

    @Test
    public void TC13() {
        System.out.println("Errors display if password and confirm password don't match when resetting password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        ForgotPasswordPage forgotPasswordPage = loginPage.gotoForgotPasswordPage();

        String registeredEmail = Constant.USERNAME;
        forgotPasswordPage.forgotPassword(registeredEmail);

        ResetPasswordPage resetPasswordPage = forgotPasswordPage.openResetPasswordLinkFromEmail(registeredEmail);
        resetPasswordPage.resetPassword(Constant.NEW_PASSWORD, Constant.MISMATCH_CONFIRM_PASSWORD, Constant.RESET_TOKEN);


        String actualGeneralMsg = resetPasswordPage.getForgotPasswordErrorMessage();
        String expectedGeneralMsg = "Could not reset password. Please correct the errors and try again.";
        Assert.assertEquals(actualGeneralMsg, expectedGeneralMsg, "General error message is not displayed as expected");

        String actualConfirmPwdMsg = resetPasswordPage.getPasswordConfirmMessage();
        String expectedConfirmPwdMsg = "The password confirmation did not match the new password.";
        Assert.assertEquals(actualConfirmPwdMsg, expectedConfirmPwdMsg, "Confirm password error message is not displayed as expected");
    }
}
