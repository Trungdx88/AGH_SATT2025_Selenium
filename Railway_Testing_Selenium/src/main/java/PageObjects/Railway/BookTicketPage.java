package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private final By _cbbDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By _cbbArriveStation = By.xpath("//select[@name='ArriveStation']");
    private final By _cbbDepartDate = By.xpath("//select[@name='Date']");
    private final By _cbbSeatType = By.xpath("//select[@name='SeatType']");
    private final By _cbbTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By _lblSuccessMessage = By.xpath("//div[@class='message success']");

    private final By pageTitle = By.tagName("h1");
    public BookTicketPage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public String getPageTitle() {
        return Constant.WEBDRIVER.findElement(pageTitle).getText();
    }

    public String getDepartStation() {
        WebElement departDropdown = Constant.WEBDRIVER.findElement(_cbbDepartStation);
        Select select = new Select(departDropdown);
        return select.getFirstSelectedOption().getText().trim();
    }

    public String getArriveStation() {
        WebElement arriveDropdown = Constant.WEBDRIVER.findElement(_cbbArriveStation);
        Select select = new Select(arriveDropdown);
        return select.getFirstSelectedOption().getText().trim();
    }

    public void selectDepartDate(String departDate) {
        WebElement dateDropdown = Constant.WEBDRIVER.findElement(_cbbDepartDate);
        Select select = new Select(dateDropdown);
        select.selectByVisibleText(departDate);
    }

    public void selectDepartStation(String departStation) {
        WebElement departDropdown = Constant.WEBDRIVER.findElement(_cbbDepartStation);
        Select select = new Select(departDropdown);
        select.selectByVisibleText(departStation);
    }

    public void selectArriveStation(String arriveStation) {
        WebElement arriveDropdown = Constant.WEBDRIVER.findElement(_cbbArriveStation);
        Select select = new Select(arriveDropdown);
        select.selectByVisibleText(arriveStation);
    }
    public void selectSeatType(String seatType) {
        WebElement seatDropdown = Constant.WEBDRIVER.findElement(_cbbSeatType);
        Select select = new Select(seatDropdown);
        select.selectByVisibleText(seatType);
    }
    public void selectTicketAmount(String ticketAmount) {
        WebElement amountDropdown = Constant.WEBDRIVER.findElement(_cbbTicketAmount);
        Select select = new Select(amountDropdown);
        select.selectByVisibleText(ticketAmount);
    }

    public void clickBookTicketButton() {
        Constant.WEBDRIVER.findElement(_btnBookTicket).click();
    }

    public String getSuccessMessage() {
        return Constant.WEBDRIVER.findElement(_lblSuccessMessage).getText().trim();
    }

    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        this.selectDepartDate(departDate);
        this.selectDepartStation(departStation);
        this.selectArriveStation(arriveStation);
        this.selectSeatType(seatType);
        this.selectTicketAmount(ticketAmount);
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        this.clickBookTicketButton();
    }
}
