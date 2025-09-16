package DataObject.model.enums.model;

import DataObject.model.enums.enums.TestData;

public class BookTicket {
    private String departDate;
    private String departStation;
    private String arriveStation;
    private String seatType;
    private String ticketAmount;

    public BookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        this.departDate = departDate;
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

    // Getter
    public String getDepartDate() { return departDate; }
    public String getDepartStation() { return departStation; }
    public String getArriveStation() { return arriveStation; }
    public String getSeatType() { return seatType; }
    public String getTicketAmount() { return ticketAmount; }

    // Factory method ví dụ

    public static BookTicket fromTimetable(String departStation, String arriveStation) {
        return new BookTicket("", departStation, arriveStation, TestData.SEAT_TYPE.getValue(), TestData.TICKET_AMOUNT.getValue());
    }
}
