package rs.atessoft;

import rs.atessoft.api.ChatNameGenerator;
import rs.atessoft.api.ChatProvider;
import rs.atessoft.api.EmailProvider;
import rs.atessoft.chat.ChatNameGeneratorImpl;
import rs.atessoft.chat.ChatProviderException;
import rs.atessoft.chat.EmailAddressValidator;

import javax.mail.MessagingException;

/**
 * @author Ivan
 */
class RegistrationService {

    private EmailAddressValidator emailAddressValidator = new EmailAddressValidator();
    private ChatNameGenerator chatNameGenerator = new ChatNameGeneratorImpl();
    private EmailProvider emailProvider;
    private ChatProvider chatProvider;

    RegistrationService(EmailProvider emailProvider, ChatProvider chatProvider) {
        this.emailProvider = emailProvider;
        this.chatProvider = chatProvider;
    }

    void registerChatName(String email) throws MessagingException, ChatProviderException {
        if (!emailAddressValidator.validateEmail(email)) {
            System.out.println("Email address not valid");
            return;
        }
        String chatName = chatNameGenerator.generateChatName(email);
        System.out.println("Chat name generated: " + chatName);
        chatProvider.registerChatName(chatName);
        emailProvider.sendEmail(email, chatName);
    }
}