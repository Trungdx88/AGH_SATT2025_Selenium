package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimetablePage {
    private final String _lnkBookTicket =
            "//table[@class='MyTable WideTable']//tr[td[2][text()='%s'] and td[3][text()='%s']]//a[text()='book ticket']";
    // Elements
    public WebElement getLnkBookTicket(String depart, String arrive) {
        String xpath = String.format(_lnkBookTicket, depart, arrive);
        return Constant.WEBDRIVER.findElement(By.xpath(xpath));
    }
    // Actions
    public BookTicketPage clickBookTicket(String depart, String arrive) {
        WebElement link = this.getLnkBookTicket(depart, arrive);
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", link);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        link.click();
        return new BookTicketPage();
    }
}
