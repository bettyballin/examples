import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Configuration
@Import({TestConfig.class})
public class EventUpdateServiceTest {
    @Autowired
    private EventUpdater eventUpdater;

    // ...
}

@Configuration
class TestConfig {
    // Define beans and configurations needed for testing
}

@Service
class EventUpdater {
    // Implementation of EventUpdater
}