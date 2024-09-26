import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
public class CustomChannelInterceptor implements ChannelInterceptor {

    @Autowired
    private PersonService personService;

    // Implement the necessary methods from ChannelInterceptor here
}