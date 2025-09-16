package Tsetcases.Railway;

import Common.Constant.Constant;
import Common.Constant.MessageHelper;
import DataObject.model.enums.enums.MessageType;
import DataObject.model.enums.model.User;
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

        homePage.gotoRegisterPage();
        User user = User.getValidRegisterUser();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(user.getUsername(),
                user.getPassword(),
                user.getConfirmPassword(),
                user.getPid());

        String actualMsg = registerPage.getSuccessMessage();
        MessageType actualEnum = MessageHelper.fromMessage(actualMsg);
        MessageType expectedEnum = MessageType.REGISTER_SUCCESS;
        Assert.assertEquals(actualEnum, expectedEnum);;
    }

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account when Confirm Password does not match Password");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        User user = User.getRegisterUserMismatchConfirm();
        registerPage.register(user.getUsername(),
                user.getPassword(),
                user.getConfirmPassword(),
                user.getPid());

        String actualMsg = registerPage.getRegisterErrorMessage();
        MessageType actualEnum = MessageHelper.fromMessage(actualMsg);
        MessageType expectedEnum = MessageType.REGISTER_ERROR;
        Assert.assertEquals(actualEnum, expectedEnum);
    }


    @Test
    public void TC11() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        User user = User.getRegisterUserEmpty();
        registerPage.register(user.getUsername(),
                user.getPassword(),
                user.getConfirmPassword(),
                user.getPid());

        String actualGeneralMsg = registerPage.getRegisterErrorMessage();
        MessageType actualGeneralEnum = MessageHelper.fromMessage(actualGeneralMsg);
        MessageType expectedGeneralEnum = MessageType.REGISTER_ERROR;
        Assert.assertEquals(actualGeneralEnum, expectedGeneralEnum);

        String actualPasswordMsg = registerPage.getValidPasswordMessage();
        MessageType actualPasswordEnum = MessageHelper.fromMessage(actualPasswordMsg);
        MessageType expectedPasswordEnum = MessageType.INVALID_PASSWORD;
        Assert.assertEquals(actualPasswordEnum, expectedPasswordEnum);

        String actualPidMsg = registerPage.getValidPidMessage();
        MessageType actualPidEnum = MessageHelper.fromMessage(actualPidMsg);
        MessageType expectedPidEnum = MessageType.INVALID_PID;
        Assert.assertEquals(actualPidEnum, expectedPidEnum);
    }
}
