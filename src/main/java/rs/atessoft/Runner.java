package rs.atessoft;

import rs.atessoft.chat.ChatProviderImpl;
import rs.atessoft.email.EmailProviderImpl;

/**
 * @author Ivan
 */
public class Runner {

    public static void main(String[] args) throws Exception {
        RegistrationService registrationService = new RegistrationService(new EmailProviderImpl(), new ChatProviderImpl());
        registrationService.registerChatName("ivan.nikolic.dev@gmail.com");
    }
}