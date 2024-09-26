import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 5000) // Adjust the rate as needed
    public void method() {
        try {
            ScheduledAuthenticationUtil.configureAuthentication();
            // do work
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ScheduledAuthenticationUtil.cleanAuthentication();
        }
    }

    private static class ScheduledAuthenticationUtil {

        public static void configureAuthentication() {
            // inject auth obj into SecurityContextHolder
        }

        public static void cleanAuthentication() {
            // SecurityContextHolder clean authentication
        }
    }
}

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableScheduling
public class ScheduledTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledTaskApplication.class, args);
    }
}