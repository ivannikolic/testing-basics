package rs.atessoft.email;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.Test;

import javax.mail.MessagingException;

import static org.testng.Assert.*;

/**
 * "This is commented out because it costs money"
 *
 * @ivan
 */
@Ignore
public class EmailProviderImplTest {

    @Test
    public void sendEmail() throws MessagingException {
        EmailProviderImpl emailProvider = new EmailProviderImpl();
        emailProvider.sendEmail("ivan.nikolic.dev@gmail.com", "ivannikolic");
    }


}