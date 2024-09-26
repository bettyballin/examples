import org.springframework.context.ApplicationEvent;

public class CustomUserEvent extends ApplicationEvent {
    private final String username;

    public CustomUserEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

No changes needed. The code is already compilable without errors.