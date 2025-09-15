package Common.Constant;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://saferailway.somee.com/";
    public static final String USERNAME = "igu9sam8@nqmo.com";
    public static final String PASSWORD = "TestCase@/";
    public static final String PASSWORD_INVALID = "testcase";
    public static final String VALID_EMAIL = "test" + System.currentTimeMillis() + "@gmail.com";
    public static final String VALID_PASSWORD = "12345678";
    public static final String VALID_CONFIRM_PASSWORD = "12345678";
    public static final String MISMATCH_CONFIRM_PASSWORD = "87654321";
    public static final String VALID_PID = "12345678";
    public static final String UNACTIVATED_EMAIL = "unactivated" + System.currentTimeMillis() + "@gmail.com";
    public static final String UNACTIVATED_PASSWORD = "12345678";
    public static final String NEW_PASSWORD = "TestCase@";
    public static final String RESET_TOKEN = "12345678";
    public static final String DEPART_STATION_ROUTE1 = "Sài Gòn";
    public static final String DEPART_STATION_ROUTE2 = "Huế";
    public static final String ARRIVE_STATION = "Nha Trang";
    public static final String SEAT_TYPE = "Soft bed with air conditioner";
    public static final String TICKET_AMOUNT = "1";
    public static final String RESET_PASSWORD_PATH = "http://www.saferailway.somee.com/Account/PasswordReset?resetToken=rgHgyDJDAA%2fVzImUzmQ2Lg%3d%3d";
}
