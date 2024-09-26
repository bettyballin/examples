import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class Temp638 {

    @Test
    @WithMockUser(username = "testuser", roles = {"USER"})
    public void myTest() throws Exception {
        // Your test logic here
        System.out.println("Test executed with mock user.");
    }

    public static void main(String[] args) {
        org.junit.platform.launcher.LauncherFactory.create().execute(
                org.junit.platform.launcher.LauncherDiscoveryRequestBuilder.request()
                        .selectors(org.junit.platform.engine.discovery.DiscoverySelectors.selectClass(Temp638.class))
                        .build()
        );
    }
}