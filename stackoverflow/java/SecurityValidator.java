import com.sun.xml.wss.impl.callback.PasswordValidationCallback;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PasswordValidator;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback.PlainTextPasswordRequest;

public class SecurityValidator implements PasswordValidator {

    private static final ThreadLocal<String> username = new ThreadLocal<>();
    private static final ThreadLocal<String> password = new ThreadLocal<>();

    @Override
    public boolean validate(PasswordValidationCallback.Request request) throws PasswordValidationCallback.PasswordValidationException {

        if (request instanceof PlainTextPasswordRequest) {
            PlainTextPasswordRequest plainText = (PlainTextPasswordRequest) request;

            if (plainText.getUsername() == null || plainText.getUsername().trim().isEmpty())
                throw new PasswordValidationCallback.PasswordValidationException("A username must be provided");
            else
                username.set(plainText.getUsername());

            if (plainText.getPassword() == null || plainText.getPassword().trim().isEmpty())
                throw new PasswordValidationCallback.PasswordValidationException("A password must be provided");
            else
                password.set(plainText.getPassword());

            return true;
        }

        return false;
    }

    public static String getUsername() {
        return username.get();
    }

    public static String getPassword() {
        return password.get();
    }

}