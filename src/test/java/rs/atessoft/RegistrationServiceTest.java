package rs.atessoft;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rs.atessoft.api.ChatProvider;
import rs.atessoft.api.EmailProvider;

/**
 * @author Ivan
 */
public class RegistrationServiceTest {

    private RegistrationService registrationService;

    @BeforeMethod
    public void beforeMethod() {
        EmailProvider emailProvider = null;
        ChatProvider chatProvider = null;
        registrationService = new RegistrationService(emailProvider, chatProvider);
    }

    @Test
    public void registerChatName(){

    }

}