public class Temp2234 {
    public static void main(String[] args) {
        // Production configuration
        String serverPort = System.getenv("server.web.port");
        String adminEmail = System.getenv("admin.email");

        //etc
        System.out.println("Server Port: " + serverPort);
        System.out.println("Admin Email: " + adminEmail);

        // Development profile configuration
        // (in a real application, this might be loaded based on the active profile)
        boolean isDevProfile = true; // Simulating dev profile activation
        if (isDevProfile) {
            boolean enableCsrf = false; // Development configurations
            System.out.println("Spring profile: dev");
            System.out.println("Security enable CSRF: " + enableCsrf);
            // Other Development configurations
        }
    }
}