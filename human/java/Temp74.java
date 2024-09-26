public class Temp74 {
    public static void main(String[] args) {
        // Placeholder for form-login configuration
        String formLoginConfig = "<form-login login-page=\"/login.html\" "
                + "default-target-url=\"/home.html\" always-use-default-target=\"true\" "
                + "authentication-success-handler-ref=\"authenticationSuccessHandler\" "
                + "authentication-failure-handler-ref=\"authenticationFailureHandler\" "
                + "login-processing-url=\"/j_spring_security_check\" />";
        
        System.out.println("Form login configuration: " + formLoginConfig);
    }
}