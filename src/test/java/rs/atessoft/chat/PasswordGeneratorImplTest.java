package rs.atessoft.chat;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static org.testng.Assert.*;

/**
 * @ivan
 */
public class PasswordGeneratorImplTest {

    @Test
    public void generateRandomPasswordLength(){
        String password = new PasswordGeneratorImpl().generateRandomPassword();

        Assert.assertEquals(password.length(), 20);
    }

    @Test
    public void generateRandomPasswordAlphanumeric(){
        Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");

        String password = new PasswordGeneratorImpl().generateRandomPassword();

        Assert.assertTrue(p.matcher(password).matches());
    }
}