public class PasswordValidatorImpl implements PasswordValidationCallback.PasswordValidator {
    private static ThreadLocal<String> passwordThreadLocal = new ThreadLocal<>();

    @Override
    public boolean validate(PasswordValidationCallback.Request request) throws PasswordValidationCallback.PasswordValidationException {
        if (request instanceof PlainTextPasswordRequest) {
            String password = ((PlainTextPasswordRequest) request).getPassword();
            passwordThreadLocal.set(password);
            // Perform your validation logic
            return true;
        }
        throw new PasswordValidationCallback.PasswordValidationException("Invalid request type");
    }

    public static String getPassword() {
        return passwordThreadLocal.get();
    }
}