package Tsetcases.Railway;

import Common.Constant.Constant;
import Common.Constant.MessageHelper;
import DataObject.model.enums.enums.MessageType;
import DataObject.model.enums.enums.TestData;
import DataObject.model.enums.model.User;
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

        String registeredEmail = TestData.REGISTERED_EMAIL.getValue();
        forgotPasswordPage.forgotPassword(registeredEmail);

        User resetUser = User.getResetPasswordMismatchToken();
        ResetPasswordPage resetPasswordPage = forgotPasswordPage.openResetPasswordLinkFromEmail(resetUser.getUsername());
        resetPasswordPage.resetPassword(resetUser.getPassword(), resetUser.getConfirmPassword(), resetUser.getPid());

        String actualTopMsg = resetPasswordPage.getForgotPasswordErrorMessage();
        MessageType actualTopEnum = MessageHelper.fromMessage(actualTopMsg);
        MessageType expectedTopEnum = MessageType.RESET_PASSWORD_TOP_ERROR;
        Assert.assertEquals(actualTopEnum, expectedTopEnum);

        String actualTokenMsg = resetPasswordPage.getValidResetTokenMessage();
        MessageType actualTokenEnum = MessageHelper.fromMessage(actualTokenMsg);
        MessageType expectedTokenEnum = MessageType.RESET_PASSWORD_TOKEN_ERROR;
        Assert.assertEquals(actualTokenEnum, expectedTokenEnum);
    }

    @Test
    public void TC13() {
        System.out.println("Errors display if password and confirm password don't match when resetting password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        ForgotPasswordPage forgotPasswordPage = loginPage.gotoForgotPasswordPage();

        String registeredEmail = TestData.REGISTERED_EMAIL.getValue();
        forgotPasswordPage.forgotPassword(registeredEmail);

        User resetUser = User.getResetPasswordMismatchConfirm();
        ResetPasswordPage resetPasswordPage = forgotPasswordPage.openResetPasswordLinkFromEmail(resetUser.getUsername());
        resetPasswordPage.resetPassword(resetUser.getPassword(), resetUser.getConfirmPassword(), resetUser.getPid());

        String actualGeneralMsg = resetPasswordPage.getForgotPasswordErrorMessage();
        MessageType actualGeneralEnum = MessageHelper.fromMessage(actualGeneralMsg);
        MessageType expectedGeneralEnum = MessageType.RESET_PASSWORD_GENERAL_ERROR;
        Assert.assertEquals(actualGeneralEnum, expectedGeneralEnum);

        String actualConfirmPwdMsg = resetPasswordPage.getPasswordConfirmMessage();
        MessageType actualConfirmEnum = MessageHelper.fromMessage(actualConfirmPwdMsg);
        MessageType expectedConfirmEnum = MessageType.RESET_PASSWORD_CONFIRM_ERROR;
        Assert.assertEquals(actualConfirmEnum, expectedConfirmEnum);
    }
}
