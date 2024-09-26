public class Temp2776 {
    public static void main(String[] args) {
        SpringSecurityConfiguration config = new SpringSecurityConfiguration(new CustomAccessDeniedHandler());
        // Add any additional code to test the configuration if needed.
    }
}

class SpringSecurityConfiguration {
    private AccessDeniedHandler accessDeniedHandler;
    
    public SpringSecurityConfiguration(AccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler; // This line was missing.
        // Other initialization code...
    }
}

interface AccessDeniedHandler {
    void handle();
}

class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle() {
        System.out.println("Access Denied");
    }
}