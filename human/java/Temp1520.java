import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

public class Temp1520 {
    public static void main(String[] args) {
        ApplicationListener<HttpSessionDestroyedEvent> listener = new ApplicationListener<HttpSessionDestroyedEvent>() {
            @Override
            public void onApplicationEvent(HttpSessionDestroyedEvent event) {
                System.out.println("Session destroyed: " + event.getId());
            }
        };

        // Example: simulate a session destroyed event
        HttpSessionDestroyedEvent event = new HttpSessionDestroyedEvent("session-id");
        listener.onApplicationEvent(event);
    }
}