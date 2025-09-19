package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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



    // Locators
    private final By txtDepartDate = By.xpath("//input[@name='FilterDpDate']");
    private final By ddlDepartStation = By.name("FilterDpStation");
    private final By ddlArriveStation = By.name("FilterArStation");
    private final By btnApplyFilter = By.xpath("//input[@value='Apply filter']");
    // Table headers -> lấy index cột theo tên header
    private final String departDateCol = "//tr[@class='TableSmallHeader']//th[normalize-space()='Depart Date']";
    private final String arriveStationCol = "//tr[@class='TableSmallHeader']//th[normalize-space()='Arrive Station']";

    // Table rows
    private final By ticketRows = By.xpath("//table//tr[contains(@class,'Row')]");

    // Elements
    public WebElement getTxtDepartDate() {
        return Constant.WEBDRIVER.findElement(txtDepartDate);
    }
    public WebElement getDdlDepartStation() {
        return Constant.WEBDRIVER.findElement(ddlDepartStation);
    }
    public WebElement getDdlArriveStation() {
        return Constant.WEBDRIVER.findElement(ddlArriveStation);
    }

    public WebElement getBtnApplyFilter() {
        return Constant.WEBDRIVER.findElement(btnApplyFilter);
    }
    public List<WebElement> getTicketRows() {
        return Constant.WEBDRIVER.findElements(ticketRows);
    }

    // Actions
    public void filterTickets(String departDate, String arriveStation ) {
        getTxtDepartDate().clear();
        getTxtDepartDate().sendKeys(departDate);



        Select arriveDropdown = new Select(getDdlArriveStation());
        arriveDropdown.selectByVisibleText(arriveStation);

        getBtnApplyFilter().click();
    }

//    public boolean isTicketDisplayed(String departDate, String arriveStation) {
//        List<WebElement> rows = Constant.WEBDRIVER.findElements(By.xpath("//table//tr[contains(@class,'Row')]"));
//        for (WebElement row : rows) {
//            String uiDate = row.findElement(By.xpath("./td[5]")).getText();   // cột Depart Date
//            String uiArrive = row.findElement(By.xpath("./td[3]")).getText(); // cột Arrive Station
//            if (uiDate.equals(departDate) && uiArrive.equals(arriveStation)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean isTicketDisplayed(String departDate, String arriveStation) {
//        List<WebElement> rows = Constant.WEBDRIVER.findElements(
//                By.xpath("//table//tr[contains(@class,'Row')]")
//        );
//
//        for (WebElement row : rows) {
//            String uiDate = row.findElement(By.xpath("./td[count(//th[text()='Depart Date']/preceding-sibling::th)+1]")).getText();
//            String uiArrive = row.findElement(By.xpath("./td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]")).getText();
//
//            if (uiDate.equals(departDate) && uiArrive.equals(arriveStation)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean isTicketDisplayed(String departDate, String arriveStation) {
//        List<WebElement> rows = Constant.WEBDRIVER.findElements(
//                By.xpath("//table//tr[contains(@class,'Row')]")
//        );
//
//        for (WebElement row : rows) {
//            // tìm đúng cột dựa vào header text
//            String uiDate = row.findElement(By.xpath(
//                    "./td[count(//tr[@class='TableSmallHeader']//th[normalize-space()='Depart Date']/preceding-sibling::th)+1]"
//            )).getText().trim();
//
//            String uiArrive = row.findElement(By.xpath(
//                    "./td[count(//tr[@class='TableSmallHeader']//th[normalize-space()='Arrive Station']/preceding-sibling::th)+1]"
//            )).getText().trim();
//
//            System.out.println("UI Date=" + uiDate + " | Expected=" + departDate);
//            System.out.println("UI Arrive=" + uiArrive + " | Expected=" + arriveStation);
//
//            if (uiDate.equals(departDate) && uiArrive.equalsIgnoreCase(arriveStation)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean isTicketDisplayed(String departDate, String arriveStation) {
        for (WebElement row : getTicketRows()) {
            String uiDate = row.findElement(By.xpath(
                    "./td[count(" + departDateCol + "/preceding-sibling::th)+1]"
            )).getText().trim();

            String uiArrive = row.findElement(By.xpath(
                    "./td[count(" + arriveStationCol + "/preceding-sibling::th)+1]"
            )).getText().trim();

            if (uiDate.equals(departDate) && uiArrive.equalsIgnoreCase(arriveStation)) {
                return true;
            }
        }
        return false;
    }


    public int getTotalPrice() {
        String xpath = "//table//tr[contains(@class,'Row')][1]/td[last()]";
        String priceText = Constant.WEBDRIVER.findElement(By.xpath(xpath)).getText().replace(",", "");
        return Integer.parseInt(priceText);
    }

}
