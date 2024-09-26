import java.util.Locale;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

public class Temp2321 {
    private static MessageSource messageSource;

    static {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("messages");
        messageSource = resourceBundleMessageSource;
    }

    public static void main(String[] args) {
        Locale currentUserLocale = LocaleContextHolder.getLocale();
        String messageKey = "your_message_key";

        // Retrieve the exception message from your custom MessageSource
        String errorMessage = messageSource.getMessage(messageKey, null, currentUserLocale);

        // Use this localized error message
        System.out.println(errorMessage);
    }
}