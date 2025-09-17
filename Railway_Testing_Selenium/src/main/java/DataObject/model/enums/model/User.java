package DataObject.model.enums.model;

import Common.Constant.Constant;
import DataObject.model.enums.enums.TestData;
import org.checkerframework.checker.units.qual.C;

public class User {
    private String username;
    private String password;
    private String confirmPassword;
    private String pid;

    // Constructor cho login
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Constructor cho register
    public User(String email, String password, String confirmPassword, String pid) {
        this.username = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.pid = pid;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getConfirmPassword() { return confirmPassword; }
    public String getPid() { return pid; }

    // Factory methods - login
    public static User getValidUser() {
        return new User(Constant.USERNAME, Constant.PASSWORD);
    }

    public static User getInvalidUser() {
        return new User(Constant.USERNAME, Constant.PASSWORD_INVALID);
    }

    public static User getInvalidUserBlank() {
        return new User(Constant.INPUT_BLANK, Constant.PASSWORD);
    }

    public static User getUserActivated() {
        return new User(Constant.UNACTIVATED_EMAIL, Constant.UNACTIVATED_PASSWORD);
    }

    public static User getValidRegisterUser() {
        return new User(Constant.VALID_EMAIL,
                Constant.VALID_PASSWORD,
                Constant.VALID_CONFIRM_PASSWORD,
                Constant.VALID_PID);
    }
    public static User getRegisterUserMismatchConfirm() {
        return new User(Constant.USERNAME, Constant.PASSWORD, Constant.MISMATCH_CONFIRM_PASSWORD, Constant.VALID_PID);
    }

    public static User getRegisterUserEmpty() {
        return new User(Constant.USERNAME, Constant.INPUT_BLANK, Constant.INPUT_BLANK, Constant.INPUT_BLANK);
    }

    public static User getResetPasswordMismatchToken() {
        return new User(Constant.USERNAME, Constant.NEW_PASSWORD, Constant.MISMATCH_CONFIRM_PASSWORD, Constant.INPUT_BLANK);
    }

    public static User getResetPasswordMismatchConfirm() {
        return new User(TestData.REGISTERED_EMAIL.getValue(), TestData.NEW_PASSWORD.getValue(), TestData.MISMATCH_CONFIRM_PASSWORD.getValue(), TestData.RESET_TOKEN.getValue());
    }
}
