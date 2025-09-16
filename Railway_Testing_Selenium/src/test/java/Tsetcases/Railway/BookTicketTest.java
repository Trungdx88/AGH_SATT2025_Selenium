package Tsetcases.Railway;

import Common.Constant.Constant;
import Common.Constant.MessageHelper;
import DataObject.model.enums.enums.MessageType;
import DataObject.model.enums.enums.PageData;
import DataObject.model.enums.enums.TestData;
import DataObject.model.enums.model.BookTicket;
import DataObject.model.enums.model.User;
import PageObjects.Railway.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest{
    @Test
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();

        User user = User.getValidUser();
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        loginPage.login(user);
        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        Select dateDropdown = new Select(Constant.WEBDRIVER.findElement(By.name("Date")));
        String departDate = dateDropdown.getOptions().get(0).getText();

        bookTicketPage.bookTicket(
                departDate,
                TestData.DEPART_STATION_ROUTE1.getValue(),
                TestData.ARRIVE_STATION.getValue(),
                TestData.SEAT_TYPE.getValue(),
                TestData.TICKET_AMOUNT.getValue()
        );
        String actualMessage = bookTicketPage.getBookTicketSuccessMessage();
        MessageType actualEnum = MessageHelper.fromMessage(actualMessage);
        MessageType expectedEnum = MessageType.BOOK_TICKET_SUCCESS;
        Assert.assertEquals(actualEnum, expectedEnum);
    }


    @Test
    public void TC15() {
        System.out.println("TC15 - User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");
        HomePage homePage = new HomePage();
        homePage.open();

        User user = User.getValidUser();
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        loginPage.login(user);

        TimetablePage timetablePage = homePage.gotoTimetablePage();

        BookTicketPage bookTicketPage = timetablePage.clickBookTicket(
                TestData.DEPART_STATION_ROUTE2.getValue(),
                TestData.DEPART_STATION_ROUTE1.getValue()
        );
        PageData actualDepartEnum = PageData.fromMessage(bookTicketPage.getDepartStation());
        PageData expectedDepartEnum = PageData.DEPART_STATION_ROUTE2;
        Assert.assertEquals(actualDepartEnum, expectedDepartEnum);

        PageData actualArriveEnum = PageData.fromMessage(bookTicketPage.getArriveStation());
        PageData expectedArriveEnum = PageData.ARRIVE_STATION_ROUTE1;
        Assert.assertEquals(actualArriveEnum, expectedArriveEnum);
    }

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();

        User user = User.getValidUser();
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        loginPage.login(user);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        Select dateDropdown = new Select(Constant.WEBDRIVER.findElement(By.name("Date")));
        String departDate = dateDropdown.getOptions().get(0).getText();

        BookTicket ticket = new BookTicket(
                departDate,
                TestData.DEPART_STATION_ROUTE1.getValue(),
                TestData.ARRIVE_STATION.getValue(),
                TestData.SEAT_TYPE.getValue(),
                TestData.TICKET_AMOUNT.getValue()
        );

        bookTicketPage.bookTicket(
                ticket.getDepartDate(),
                ticket.getDepartStation(),
                ticket.getArriveStation(),
                ticket.getSeatType(),
                ticket.getTicketAmount()
        );
        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        myTicketPage.cancelFirstTicket();
        myTicketPage.confirmCancelTicket();

        boolean isTicketCancelled = myTicketPage.isTicketDisappeared();
        Assert.assertTrue(isTicketCancelled);
    }

}
