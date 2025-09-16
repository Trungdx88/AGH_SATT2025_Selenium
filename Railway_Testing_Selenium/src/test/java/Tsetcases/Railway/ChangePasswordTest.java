package Tsetcases.Railway;

import Common.Constant.Constant;
import Common.Constant.MessageHelper;
import DataObject.model.enums.enums.MessageType;
import DataObject.model.enums.enums.TestData;
import DataObject.model.enums.model.User;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
    @Test
    public void TC09() {
        System.out.println("TC09 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();

        User user = User.getValidUser();
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        loginPage.login(user);

        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        changePasswordPage.ChangePassword(
                TestData.PASSWORD.getValue(),
                TestData.NEW_PASSWORD.getValue(),
                TestData.NEW_PASSWORD.getValue()
        );
        String actualMsg = changePasswordPage.getChangePasswordSuccessMsg();
        MessageType actualEnum = MessageHelper.fromMessage(actualMsg);
        MessageType expectedEnum = MessageType.CHANGE_PASSWORD_SUCCESS;
        Assert.assertEquals(actualEnum, expectedEnum);
    }
}
