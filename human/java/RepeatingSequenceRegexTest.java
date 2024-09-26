import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;

class PasswordData {
    private final String password;

    public PasswordData(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

class PasswordValidator {
    private final IllegalRegexRule rule;

    public PasswordValidator(IllegalRegexRule rule) {
        this.rule = rule;
    }

    public ValidationResult validate(PasswordData passwordData) {
        if (rule.isValid(passwordData)) {
            return new ValidationResult(true);
        } else {
            return new ValidationResult(false);
        }
    }
}

class IllegalRegexRule {
    private final Pattern pattern;

    public IllegalRegexRule(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean isValid(PasswordData passwordData) {
        return !pattern.matcher(passwordData.getPassword()).find();
    }
}

class ValidationResult {
    private final boolean valid;

    public ValidationResult(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }
}

public class RepeatingSequenceRegexTest {
    final PasswordValidator validator = new PasswordValidator(
            new IllegalRegexRule("(.{1,})\\1")
    );

    @Test
    public void checks() {
        assertTrue(validator.validate(new PasswordData("normal")).isValid());
        assertTrue(validator.validate(new PasswordData("abcdef")).isValid());
        assertTrue(validator.validate(new PasswordData("abacadaeaf")).isValid());
        assertTrue(validator.validate(new PasswordData("xyzxy")).isValid());
        assertTrue(validator.validate(new PasswordData("12345")).isValid());
        assertTrue(validator.validate(new PasswordData("121314")).isValid());
        assertTrue(validator.validate(new PasswordData("1234123121")).isValid());
        assertTrue(validator.validate(new PasswordData("123xy123")).isValid());
        assertTrue(validator.validate(new PasswordData("1")).isValid());
        assertTrue(validator.validate(new PasswordData("")).isValid());

        assertFalse(validator.validate(new PasswordData("apple")).isValid());
        assertFalse(validator.validate(new PasswordData("banana")).isValid());
        assertFalse(validator.validate(new PasswordData("112233")).isValid());
        assertFalse(validator.validate(new PasswordData("123123")).isValid());
        assertFalse(validator.validate(new PasswordData("1212")).isValid());
        assertFalse(validator.validate(new PasswordData("11")).isValid());
        assertFalse(validator.validate(new PasswordData("123xy123xy")).isValid());
    }
}