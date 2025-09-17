package DataObject.model.enums.enums;


public enum PageData {
    ARRIVE_STATION_ROUTE1(TestData.DEPART_STATION_ROUTE1.getValue()),
    DEPART_STATION_ROUTE2(TestData.DEPART_STATION_ROUTE2.getValue()),
    SEAT_TYPE(TestData.SEAT_TYPE.getValue()),
    TICKET_AMOUNT(TestData.TICKET_AMOUNT.getValue());;

    private final String text;
    PageData(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public static PageData fromMessage(String message) {
        for (PageData pd : values()) {
            if (pd.getText().equals(message)) {
                return pd;
            }
        }
        throw new IllegalArgumentException("No matching enum for: " + message);
    }
}
