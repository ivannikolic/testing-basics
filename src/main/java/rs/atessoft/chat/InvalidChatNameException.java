package rs.atessoft.chat;

/**
 * @ivan
 */
public class InvalidChatNameException extends Exception {

    private Type type;

    public InvalidChatNameException(Type type, String message) {
        super(message);
        this.type = type;
    }

    public enum  Type {
        BLANK, TOO_SHORT, TOO_LONG, MODERATOR_KEYWORD
    }

    public Type getType() {
        return type;
    }
}
