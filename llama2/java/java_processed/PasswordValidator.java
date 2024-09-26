import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordPolicy;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.RuleResultDetail;

import java.util.Arrays;

public class PasswordValidator {
    public static void main(String[] args) {
        // Define a password policy that uses custom rules
        PasswordPolicy policy = new PasswordPolicy("My Policy", Arrays.asList(new LengthRule(8, 16), new NoConsecutiveSequencesRule()));

        // Validate a password
        PasswordData passwordData = new PasswordData("password123");

        RuleResult result = policy.validate(passwordData);

        if (result.isValid()) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
            result.getDetails().forEach(detail -> System.out.println(detail.getErrorCode()));
        }
    }
}

// Custom Rule: NoConsecutiveSequencesRule
class NoConsecutiveSequencesRule implements Rule {

    @Override
    public RuleResult validate(PasswordData passwordData) {
        String password = passwordData.getPassword();
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) + 1 == password.charAt(i + 1)) {
                return new RuleResult(false, Arrays.asList(new RuleResultDetail("NO_CONSECUTIVE_SEQUENCES", "No consecutive sequences allowed")));
            }
        }
        return new RuleResult(true);
    }

    @Override
    public String getErrorCode() {
        return "NO_CONSECUTIVE_SEQUENCES";
    }
}