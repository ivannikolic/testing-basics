package rs.atessoft.api;

/**
 * This service is used to generate chat names out of emails
 *
 * @ivan
 */
public interface ChatNameGenerator {


    /**
     * Generate chat name from email using following rules:
     * <ul>
     * <li>Only alphanumeric alphanumeric characters should be used, every other character should be removed</li>
     * <li>Chat name should be in lower case</li>
     * <li>Chat name must be at least 5 characters long - additional characters might be added</li>
     * <li>Chat name must be at at most 11 characters long - some characters at the end might be removed</li>
     * <li>Chat name must not contain word "admin". If it does it will be replaced by word "user"</li>
     * </ul>
     * Always return chat name, no exception should be thrown
     *
     * @param email user's email address
     * @return generated chat name
     */
    String generateChatName(String email);
}
