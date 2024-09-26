import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        LoginFailureEventListener listener = context.getBean(LoginFailureEventListener.class);
        System.out.println("Bean loaded: " + listener);
        context.close();
    }
}

@Configuration
class AppConfig {
    @Bean
    public LoginFailureEventListener loginFailureEventListener() {
        return new LoginFailureEventListener(eventDispatcher());
    }

    @Bean
    public EventDispatcher eventDispatcher() {
        return new EventDispatcher();
    }
}

class LoginFailureEventListener {
    private EventDispatcher eventDispatcher;

    public LoginFailureEventListener(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public String toString() {
        return "LoginFailureEventListener{" +
                "eventDispatcher=" + eventDispatcher +
                '}';
    }
}

class EventDispatcher {
    @Override
    public String toString() {
        return "EventDispatcher{}";
    }
}