import org.springframework.security.access.AccessDeniedException;

public class ErrorConstants {
    public static final String ACCESS_DENIED_ERROR = AccessDeniedException.class.getSimpleName() + "=ERROR";
}