package rs.atessoft.chat;

import org.apache.commons.lang3.RandomStringUtils;

import static rs.atessoft.chat.InvalidChatNameException.Type.*;

/**
 * @ivan
 */
public class ChatNameGeneratorImpl implements ChatNameGenerator {

    private static final String NON_ALPHA_NUMERIC_REGEX = "[^A-Za-z0-9]";
    private static final int CHAT_NAME_MIN_LENGTH = 5;
    private static final int CHAT_NAME_MAX_LENGTH = 11;

    @Override
    public String generateChatName(String email) {
        String chatName = extractUsernameFromEmail(email);

        chatName = chatName.replaceAll(NON_ALPHA_NUMERIC_REGEX, "");
        chatName = chatName.toLowerCase();
        try {
            validateChatName(chatName);
        } catch (InvalidChatNameException e) {
            switch (e.getType()) {
                case MODERATOR_KEYWORD:
                    chatName = chatName.replace("admin", "user");
                case BLANK:
                case TOO_SHORT:
                    int diff = CHAT_NAME_MIN_LENGTH - chatName.length();
                    if (diff > 0) {
                        chatName += RandomStringUtils.randomAlphanumeric(diff);
                    }
            }
            if (chatName.length() > CHAT_NAME_MAX_LENGTH) {
                chatName = chatName.substring(0, CHAT_NAME_MAX_LENGTH);
            }
            chatName = generateChatName(chatName);
        }
        return chatName;
    }

    private void validateChatName(String chatName) throws InvalidChatNameException {
        if (chatName == null || chatName.trim().isEmpty()) {
            throw new InvalidChatNameException(BLANK, "Blank");
        }
        if (chatName.length() < CHAT_NAME_MIN_LENGTH) {
            throw new InvalidChatNameException(TOO_SHORT, "Too short");
        }
        if (chatName.length() > CHAT_NAME_MAX_LENGTH) {
            throw new InvalidChatNameException(TOO_LONG, "Too long");
        }
        if (chatName.contains("admin")) {
            throw new InvalidChatNameException(MODERATOR_KEYWORD, "Chat moderator keyword");
        }
    }

    private String extractUsernameFromEmail(String email) {
        int index = email.indexOf('@');
        if (index < 0) {
            return email;
        }
        return email.substring(0, index);
    }

}
