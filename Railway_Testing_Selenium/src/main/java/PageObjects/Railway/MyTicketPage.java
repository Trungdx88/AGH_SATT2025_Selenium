package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyTicketPage extends GeneralPage{
   private final By btnCancelFirstTicket = By.xpath("/table[@class='MyTable']//tr[td[input[contains(@onclick,'%s')]]]//input[@type='button' and @value='Cancel']");

    public void cancelFirstTicket() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));
        WebElement cancelBtn = wait.until(ExpectedConditions.elementToBeClickable(btnCancelFirstTicket));
        cancelBtn.click();
    }

    public void confirmCancelTicket() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
    }
    public boolean isTicketDisappeared() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(btnCancelFirstTicket));
        } catch (TimeoutException e) {
            return false;
        }
    }
}
