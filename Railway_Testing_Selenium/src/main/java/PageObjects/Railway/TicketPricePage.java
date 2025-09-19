package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class TicketPricePage extends GeneralPage{
    // Locators
    private final By lnkTicketPrice = By.xpath("//span[text()='Ticket price']");
    private final String lnkCheckPrice = "//li[contains(normalize-space(),'Trains depart from %s')]/ancestor::tr/following-sibling::tr//a[contains(text(),'Check Price')]";
    private final String lnkBookTicket = "//td[text()='%s']/following-sibling::td/a[text()='Book ticket']";


    // Actions

public void checkPrice(String departStation) {
    String xpath = String.format(lnkCheckPrice, departStation);
    WebElement element = Constant.WEBDRIVER.findElement(By.xpath(xpath));

    // Scroll tới element
    ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);

    try {
        element.click();
    } catch (ElementClickInterceptedException e) {
        // Nếu vẫn bị che thì dùng JS click
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].click();", element);
    }
}
    public void bookTicket(String seatType) {
        String xpath = String.format(lnkBookTicket, seatType);
        Constant.WEBDRIVER.findElement(By.xpath(xpath)).click();
    }

    public int getUnitPrice(String seatType) {
        String xpath = "//td[text()='" + seatType + "']/following-sibling::td[1]";
        String priceText = Constant.WEBDRIVER.findElement(By.xpath(xpath)).getText();
        String numberOnly = priceText.replaceAll("[^0-9]", ""); // chỉ giữ số
        return Integer.parseInt(numberOnly);
    }


}
