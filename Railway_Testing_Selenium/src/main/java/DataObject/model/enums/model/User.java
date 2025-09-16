package DataObject.model.enums.model;

import Common.Constant.Constant;
import DataObject.model.enums.enums.TestData;

public class User {
    private String username;
    private String password;
    private String confirmPassword;
    private String pid; // Citizen ID

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
        return new User(TestData.USERNAME.getValue(), TestData.PASSWORD.getValue());
    }

    public static User getInvalidUser() {
        return new User(TestData.USERNAME.getValue(), TestData.PASSWORD_INVALID.getValue());
    }

    public static User getInvalidUserBlank() {
        return new User(TestData.INPUT_BLANK.getValue(), TestData.PASSWORD.getValue());
    }

    public static User getUserActivated() {
        return new User(TestData.UNACTIVATED_EMAIL.getValue(), TestData.UNACTIVATED_PASSWORD.getValue());
    }

    public static User getValidRegisterUser() {
        return new User(TestData.VALID_EMAIL.getValue(),
                TestData.VALID_PASSWORD.getValue(),
                TestData.VALID_CONFIRM_PASSWORD.getValue(),
                TestData.VALID_PID.getValue());
    }
    public static User getRegisterUserMismatchConfirm() {
        return new User(TestData.USERNAME.getValue(), TestData.PASSWORD.getValue(), TestData.MISMATCH_CONFIRM_PASSWORD.getValue(), TestData.VALID_PID.getValue());
    }

    public static User getRegisterUserEmpty() {
        return new User(TestData.USERNAME.getValue(), TestData.INPUT_BLANK.getValue(), TestData.INPUT_BLANK.getValue(), TestData.INPUT_BLANK.getValue());
    }

    public static User getResetPasswordMismatchToken() {
        return new User(TestData.USERNAME.getValue(), TestData.NEW_PASSWORD.getValue(), TestData.MISMATCH_CONFIRM_PASSWORD.getValue(), TestData.INPUT_BLANK.getValue());
    }

    public static User getResetPasswordMismatchConfirm() {
        return new User(TestData.REGISTERED_EMAIL.getValue(), TestData.NEW_PASSWORD.getValue(), TestData.MISMATCH_CONFIRM_PASSWORD.getValue(), TestData.RESET_TOKEN.getValue());
    }
}
