package DataObject.model.enums.enums;

import Common.Constant.Constant;

public enum TestData {
    USERNAME(Constant.USERNAME),
    PASSWORD(Constant.PASSWORD),
    PASSWORD_INVALID(Constant.PASSWORD_INVALID),
    INPUT_BLANK(Constant.INPUT_BLANK),
    REGISTERED_EMAIL(Constant.USERNAME),
    NEW_PASSWORD(Constant.NEW_PASSWORD),
    MISMATCH_CONFIRM_PASSWORD(Constant.MISMATCH_CONFIRM_PASSWORD),
    VALID_EMAIL(Constant.VALID_EMAIL),
    VALID_PASSWORD(Constant.VALID_PASSWORD),
    VALID_CONFIRM_PASSWORD(Constant.VALID_CONFIRM_PASSWORD),
    VALID_PID(Constant.VALID_PID),
    UNACTIVATED_EMAIL(Constant.UNACTIVATED_EMAIL),
    UNACTIVATED_PASSWORD(Constant.UNACTIVATED_PASSWORD),
    RESET_TOKEN(Constant.RESET_TOKEN),
    DEPART_STATION_ROUTE1(Constant.DEPART_STATION_ROUTE1),
    ARRIVE_STATION(Constant.ARRIVE_STATION),
    SEAT_TYPE(Constant.SEAT_TYPE),
    TICKET_AMOUNT(Constant.TICKET_AMOUNT),
    DEPART_STATION_ROUTE2(Constant.DEPART_STATION_ROUTE2);

    private final String value;
    TestData(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
