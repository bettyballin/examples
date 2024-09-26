import org.springframework.scheduling.annotation.Scheduled;

public class MyClass5 {

    @Scheduled
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