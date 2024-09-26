import org.passay.*;

public class NoRepeatSequenceRule implements Rule {
    private int sequenceLength;

    public NoRepeatSequenceRule(int sequenceLength) {
        this.sequenceLength = sequenceLength;
    }

    @Override
    public RuleResult validate(PasswordData passwordData) {
        String password = passwordData.getPassword();
        RuleResult result = new RuleResult(true);

        for (int i = 0; i <= password.length() - sequenceLength; i++) {
            String sequence = password.substring(i, i + sequenceLength);
            String remainingPassword = password.substring(i + sequenceLength);
            if (remainingPassword.contains(sequence)) {
                result.setValid(false);
                result.addDetail(new RuleResultDetail("ILLEGAL_SEQUENCE", new Object[] {sequence}));
                break;
            }
        }
        return result;
    }
}