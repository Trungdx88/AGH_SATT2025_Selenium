package Tsetcases.Railway;

import Common.Constant.Constant;
import DataObject.model.enums.enums.TestData;
import DataObject.model.enums.model.BookTicket;
import DataObject.model.enums.model.User;
import PageObjects.Railway.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FinalTest extends BaseTest{
   @Test
   public void FTTC702_FilterTickets() {
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        loginPage.login(User.getValidUser());

        homePage.gotoBookTicketPage();

        BookTicketPage bookTicketPage = new BookTicketPage();
        List<BookTicket> tickets = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
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

            tickets.add(ticket);
        }
        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.gotoMyTicketPage();

        BookTicket expectedTicket = tickets.get(3);
        myTicketPage.filterTickets(expectedTicket.getDepartDate(), expectedTicket.getArriveStation());
        Assert.assertTrue(
                myTicketPage.isTicketDisplayed(expectedTicket.getDepartDate(), expectedTicket.getArriveStation()),
                "Ticket not found after filtering!"
        );
    }


    @Test
    public void FTTC703_UserCanBookTicketWithKnownPrice() {
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        loginPage.login(User.getValidUser());

        homePage.gotoTicketPricePage();
        TicketPricePage pricePage = new TicketPricePage();
        pricePage.checkPrice("Huế");

        int unitPrice = pricePage.getUnitPrice("Hard seat");
        pricePage.bookTicket("Hard seat");

        BookTicketPage bookTicketPage = new BookTicketPage();
        Select dateDropdown = new Select(Constant.WEBDRIVER.findElement(By.name("Date")));
        String departDate = dateDropdown.getOptions().get(0).getText();

        bookTicketPage.bookTicket(
                departDate,
                TestData.DEPART_STATION_ROUTE1.getValue(),
                TestData.ARRIVE_STATION.getValue(),
                TestData.SEAT_TYPE.getValue(),
                TestData.TICKET_AMOUNT.getValue()
        );
        MyTicketPage myTicketPage = new MyTicketPage();
        int actualTotal = myTicketPage.getTotalPrice();
        Assert.assertEquals(actualTotal, unitPrice * 2, "Total price is incorrect!");
    }
}
