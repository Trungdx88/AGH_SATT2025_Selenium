package Tsetcases.Railway;

import Common.Constant.Constant;
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

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        Select dateDropdown = new Select(Constant.WEBDRIVER.findElement(By.name("Date")));
        String departDate = dateDropdown.getOptions().get(0).getText();

        bookTicketPage.bookTicket(departDate,Constant.DEPART_STATION_ROUTE1, Constant.ARRIVE_STATION,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);

        String actualMessage = bookTicketPage.getBookTicketSuccessMessage();
        String expectedMessage = "Ticket booked successfully!";
        Assert.assertEquals(actualMessage, expectedMessage, "Booking success message is incorrect!");
    }


    @Test
    public void TC15() {
        System.out.println("TC15 - User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        TimetablePage timetablePage = homePage.gotoTimetablePage();

        BookTicketPage bookTicketPage = timetablePage.clickBookTicket(Constant.DEPART_STATION_ROUTE2, Constant.DEPART_STATION_ROUTE1);

        String actualArriveStation = bookTicketPage.getArriveStation();
        String expectedArriveStation = Constant.DEPART_STATION_ROUTE1;
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is incorrect");

        String actualDepartStation = bookTicketPage.getDepartStation();
        String expectedDepartStation = Constant.DEPART_STATION_ROUTE2;
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is incorrect");
    }

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        Select dateDropdown = new Select(Constant.WEBDRIVER.findElement(By.name("Date")));
        String departDate = dateDropdown.getOptions().get(0).getText();
        bookTicketPage.bookTicket(departDate,Constant.DEPART_STATION_ROUTE1, Constant.ARRIVE_STATION,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        myTicketPage.cancelFirstTicket();
        myTicketPage.confirmCancelTicket();

        boolean isTicketCancelled = myTicketPage.isTicketDisappeared();
        Assert.assertTrue(isTicketCancelled, "The canceled ticket is still displayed!");
    }

}
