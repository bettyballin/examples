import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.RuleResultDetail;
import org.passay.PasswordData;
import org.passay.ValidationError;
import org.passay.ValidationResult;

public class NoConsecutiveSequencesRule implements Rule {
    @Override
    public RuleResult validate(PasswordData passwordData) {
        String password = passwordData.getPassword();

        // Iterate through each character in the password
        for (int i = 0; i < password.length() - 1; i++) {
            char currChar = password.charAt(i);
            // Check if there's a sequence of the same character immediately following
            if (currChar == password.charAt(i + 1)) {
                // Found a violation!
                RuleResult result = new RuleResult(false);
                result.getDetails().add(new RuleResultDetail("noConsecutiveSequences", new ValidationError("Password contains consecutive sequences of characters")));
                return result;
            }
        }

        return new RuleResult(true);
    }

    public static void main(String[] args) {
        NoConsecutiveSequencesRule rule = new NoConsecutiveSequencesRule();
        PasswordData passwordData = new PasswordData("password");
        RuleResult result = rule.validate(passwordData);

        if (result.isValid()) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
            for (RuleResultDetail detail : result.getDetails()) {
                System.out.println(detail.getErrorCode() + ": " + detail.getErrorParameters().get("message"));
            }
        }
    }
}