package rs.atessoft.chat;

import org.apache.commons.lang3.RandomStringUtils;
import rs.atessoft.api.PasswordGenerator;

/**
 * @ivan
 */
public class PasswordGeneratorImpl implements PasswordGenerator {
    @Override
    public String generateRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(20);
    }
}
