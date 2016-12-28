package rs.atessoft.api;

import javax.mail.MessagingException;

/**
 * @author Ivan
 */
public interface EmailProvider {

    void sendEmail(String email, String chatName) throws MessagingException;
}
