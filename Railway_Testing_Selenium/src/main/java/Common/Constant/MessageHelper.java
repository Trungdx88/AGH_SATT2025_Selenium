package Common.Constant;

import DataObject.model.enums.enums.MessageType;

public class MessageHelper {
    public static MessageType fromMessage(String actualMsg) {
        for (MessageType type : MessageType.values()) {
            if (type.getText().equals(actualMsg)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No matching enum for: " + actualMsg);
    }
}
