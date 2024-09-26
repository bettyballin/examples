import org.springframework.boot.test.context.SpringBootTest;
import my.package.EventUpdater;
import my.package.EventTypePermission;

@SpringBootTest(classes={EventUpdater.class, EventTypePermission.class})
public class EventUpdaterTest {
    // Test cases here
}