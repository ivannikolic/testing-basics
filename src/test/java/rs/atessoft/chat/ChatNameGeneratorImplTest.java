package rs.atessoft.chat;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rs.atessoft.api.ChatNameGenerator;

import java.util.regex.Pattern;

/**
 * @ivan
 */
public class ChatNameGeneratorImplTest {

    private ChatNameGenerator chatNameGenerator;

    @BeforeMethod
    public void initialize() {
        chatNameGenerator = new ChatNameGeneratorImpl();
    }

    @Test
    public void generateChatNameOnlyCharacters() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("belgrade@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "belgrade");
    }

    @Test
    public void generateChatNameOnlyNumbers() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("123456@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "123456");
    }

    @Test
    public void generateChatNameUpperCase() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("BELGRADE@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "belgrade");
    }

    @Test
    public void generateChatNameAlphaNumeric() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("ivan123@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "ivan123");
    }

    @Test
    public void generateChatNameTooLong() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("ivan123456789@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "ivan1234567");
    }

    @Test
    public void generateChatNameTooShort() {
        //prepare
        Pattern p = Pattern.compile("^ivan[A-Za-z0-9]$");
        //exercise
        String suggestion = chatNameGenerator.generateChatName("ivan@gmail.com");
        //verify
        Assert.assertTrue(p.matcher(suggestion).matches(), suggestion + " doesn't match regex " + p.pattern());
    }

    @Test
    public void generateChatNameStripOutDot() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("hercules.58@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "hercules58");
    }

    @Test
    public void generateChatNameStripOutSpecialCharacter() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("V$gard@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "vgard");
    }

    @Test
    public void generateChatNameStripOutSpecialCharacterAndMaxLength() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("v%rh/{ltnpsm}%ig@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "vrhltnpsmig");
    }

    @Test
    public void generateChatNameStripOutSpecialCharacterAndSubstring() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("v%rh/{ltnpsm}%ig1234@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "vrhltnpsmig");
    }

    @Test
    public void generateChatNameTooShortAndStripOutSpecialCharacter() {
        //prepare
        Pattern p = Pattern.compile("^lwen[A-Za-z0-9]$");
        //exercise
        String suggestion = chatNameGenerator.generateChatName("L%wen");
        //verify
        Assert.assertTrue(p.matcher(suggestion).matches(), suggestion + " doesn't match regex " + p.pattern());
    }

    @Test
    public void generateChatNameEmpty() {
        //prepare
        Pattern p = Pattern.compile("^[A-Za-z0-9]{5}$");
        //exercise
        String suggestion = chatNameGenerator.generateChatName("");
        //verify
        Assert.assertTrue(p.matcher(suggestion).matches(), suggestion + " doesn't match regex " + p.pattern());
    }

    @Test
    public void generateChatNameSpace() {
        //prepare
        Pattern p = Pattern.compile("^[A-Za-z0-9]{5}$");
        //exercise
        String suggestion = chatNameGenerator.generateChatName(" ");
        //verify
        Assert.assertTrue(p.matcher(suggestion).matches(), suggestion + " doesn't match regex " + p.pattern());
    }

    @Test
    public void generateChatNameOnlyDomain() {
        //prepare
        Pattern p = Pattern.compile("^[A-Za-z0-9]{5}$");
        //exercise
        String suggestion = chatNameGenerator.generateChatName("@gmail.com");
        //verify
        Assert.assertTrue(p.matcher(suggestion).matches(), suggestion + " doesn't match regex " + p.pattern());
    }

    @Test
    public void generateChatNameAdmin() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("i_am_admin@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "iamuser");
    }

    @Test
    public void generateChatNameAdminMaxLength() {
        //exercise
        String suggestion = chatNameGenerator.generateChatName("my_name_is_admin@gmail.com");
        //verify
        Assert.assertEquals(suggestion, "mynameisadm");
    }
}