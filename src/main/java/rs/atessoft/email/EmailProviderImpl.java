package rs.atessoft.email;

import org.apache.commons.lang3.RandomStringUtils;
import rs.atessoft.api.EmailProvider;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Ivan
 */
public class EmailProviderImpl implements EmailProvider {

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String USERNAME = "ir360stage@gmail.com";
    private static final String PASSWORD = "avexoktssymoxwwg";

    @Override
    public void sendEmail(String email, String chatName) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        String text = "Hello pilići,"
                + "\n\nYour are registered to AtesSoft's chat with name: "
                + "\n" + chatName
                + "\nYour password is: " + RandomStringUtils.randomAlphanumeric(20)
                + "\n\nSincerely yours,"
                + "\nMarija Zivkovic";
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("info@atessoft.rs"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("Atessoft chat registration");
        message.setText(text);

        Transport.send(message);
        System.out.println("email sent to " + email + " with text: \n" + text + "\n");
        System.out.println("this email costs 1$");
    }
}
