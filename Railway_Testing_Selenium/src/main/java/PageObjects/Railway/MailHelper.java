package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailHelper extends GeneralPage{
    private final WebDriver driver;
    private final WebDriverWait wait;
    public MailHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public String getResetPasswordLink(String email) {
        driver.get("https://mail.td/en/mail/" + email);
        WebElement firstMail = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class,'mail-from')])[1]"))
        );
        firstMail.click();
        String resetLink = Constant.RESET_PASSWORD_PATH;
        driver.get(resetLink);
        return resetLink;
    }
}
