package rs.atessoft;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rs.atessoft.api.ChatProvider;
import rs.atessoft.api.EmailProvider;
import rs.atessoft.chat.ChatProviderException;

import javax.mail.MessagingException;

/**
 * @author Ivan
 */
public class RegistrationServiceTest {

    private RegistrationService registrationService;
    private EmailProvider emailProvider;
    private ChatProvider chatProvider;

    @BeforeMethod
    public void beforeMethod() throws ChatProviderException {
        emailProvider = new EmailProvider() {
            @Override
            public void sendEmail(String email, String chatName) throws MessagingException {
                System.out.println("Email sending skipped");
            }
        };
        chatProvider = Mockito.mock(ChatProvider.class);
        Mockito.doNothing().when(chatProvider).registerChatName(Mockito.anyString());
        Mockito.doThrow(RuntimeException.class).when(chatProvider).registerChatName("IVAN");
        registrationService = new RegistrationService(emailProvider, chatProvider);
    }

    @Test
    public void registerChatName() throws MessagingException, ChatProviderException {
        //exercise
        registrationService.registerChatName("ivan.nikolic.dev@gmail.com");

        //verify
        Mockito.verify(chatProvider, Mockito.times(1)).registerChatName(Mockito.eq("ivannikolic"));
    }

}