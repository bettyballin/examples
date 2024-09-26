import java.util.Objects;

public class NoImmediateSequenceRule implements Rule {

    private final int sequenceLength;

    public NoImmediateSequenceRule(int sequenceLength) {
        if (sequenceLength < 1 || sequenceLength > 10) { 
            throw new IllegalArgumentException("Invalid sequence length: " + sequenceLength);
        }
        this.sequenceLength = sequenceLength;
    }

    @Override
    public boolean isValid(PasswordData passwordData) {
        String password = passwordData.getPassword();
        for (int i = 0; i <= password.length() - 2 * sequenceLength; ++i) {
            if (isSequence(password, i)) return false;
        }
        return true;
    }

    private boolean isSequence(String password, int start) {
        String sub1 = password.substring(start, start + sequenceLength);
        String sub2 = password.substring(start + sequenceLength, start + 2 * sequenceLength);
        return Objects.equals(sub1, sub2);
    }

    public static void main(String[] args) {
        PasswordData passwordData = new PasswordData("passwordpassword");
        NoImmediateSequenceRule rule = new NoImmediateSequenceRule(4);
        System.out.println(rule.isValid(passwordData));
    }
}

class PasswordData {
    private final String password;

    public PasswordData(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

interface Rule {
    boolean isValid(PasswordData passwordData);
}