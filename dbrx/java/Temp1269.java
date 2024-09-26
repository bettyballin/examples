import java.util.Arrays;
import java.util.List;

public class Temp1269 {
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator(
            Arrays.asList(
                // other rules...
                new NoImmediateSequenceRule(3) // adjust the length as needed
            )
        );
    }
}

class PasswordValidator {
    private List<Rule> rules;

    public PasswordValidator(List<Rule> rules) {
        this.rules = rules;
    }

    // Add validation logic here
}

interface Rule {
    boolean validate(String password);
}

class NoImmediateSequenceRule implements Rule {
    private int length;

    public NoImmediateSequenceRule(int length) {
        this.length = length;
    }

    @Override
    public boolean validate(String password) {
        for (int i = 0; i <= password.length() - length; i++) {
            if (isSequence(password.substring(i, i + length))) {
                return false;
            }
        }
        return true;
    }

    private boolean isSequence(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if ((str.charAt(i) + 1) != str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}