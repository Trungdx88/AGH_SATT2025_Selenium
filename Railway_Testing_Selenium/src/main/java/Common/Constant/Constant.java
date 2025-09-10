package Common.Constant;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://saferailway.somee.com/";
    public static final String USERNAME = "igu9sam8@nqmo.com";
    public static final String PASSWORD = "TestCase@";
    public static final String PASSWORD_INVALID = "testcase";
    public static final String VALID_EMAIL = "test" + System.currentTimeMillis() + "@gmail.com";
    public static final String VALID_PASSWORD = "12345678";
    public static final String VALID_CONFIRM_PASSWORD = "12345678";
    public static final String MISMATCH_CONFIRM_PASSWORD = "87654321";
    public static final String VALID_PID = "12345678";
    public static final String UNACTIVATED_EMAIL = "unactivated" + System.currentTimeMillis() + "@gmail.com";
    public static final String UNACTIVATED_PASSWORD = "12345678";
    public static final String NEW_PASSWORD = "TestCase@/";
}
