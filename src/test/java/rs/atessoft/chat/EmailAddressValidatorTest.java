package rs.atessoft.chat;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @ivan
 */
public class EmailAddressValidatorTest {

    private static final String EMAIL_DATA_PROVIDER = "emailDataProvider";

    @DataProvider(name = EMAIL_DATA_PROVIDER)
    public Object[][] emailTestCases () {
        return new Object[][] {
                {"ivan.nikoli.dev@gmail.com", true, "Regular"},
                {"ivan.nikoli dev@gmail.com", false, "No space allowed"},
                {"ivan.nikoli..dev@gmail.com", false, "Two dots next to each other"},
                {"gmail.com", false, "No @"},
                {"ivan@gmail", false, "No extension"},
        };
    }

    @Test(dataProvider = EMAIL_DATA_PROVIDER)
    public void validateEmail(String email, boolean shouldBeValid, String description) {
        boolean isValid = new EmailAddressValidator().validateEmail(email);

        Assert.assertEquals(isValid, shouldBeValid, description);
    }


}