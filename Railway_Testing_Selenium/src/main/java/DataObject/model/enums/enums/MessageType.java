package DataObject.model.enums.enums;

import Common.Constant.Constant;

public enum MessageType {
    WELCOME("Welcome " + Constant.USERNAME) ,
    INVALID_LOGIN ("There was a problem with your login and/or errors exist in your form."),
    PASSWORD_MISMATCH("Invalid username or password. Please try again."),
    BOOKTICKET_TITLE("Book ticket"),
    ATTEMPT_WARNING("You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes."),
    CHANGEPASSWORD_TITLE("Change password"),
    REGISTER_SUCCESS("Thank you for registering your account"),
    REGISTER_ERROR("There're errors in the form. Please correct the errors and try again."),
    INVALID_PASSWORD("Invalid password length."),
    INVALID_PID("Invalid ID length."),
    RESET_PASSWORD_TOP_ERROR("The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one."),
    RESET_PASSWORD_TOKEN_ERROR("The password reset token is invalid."),
    RESET_PASSWORD_GENERAL_ERROR("Could not reset password. Please correct the errors and try again."),
    RESET_PASSWORD_CONFIRM_ERROR("The password confirmation did not match the new password."),
    BOOK_TICKET_SUCCESS("Ticket booked successfully!"),
    CHANGE_PASSWORD_SUCCESS("Your password has been updated");

    private final String text;
    MessageType(String text) {
        this.text = text;
    }
    public String getText(Object... args) {
        return String.format(text, args);
    }
}
