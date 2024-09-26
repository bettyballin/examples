public class Temp633 {
    public static void main(String[] args) {
        // Simulating security form-login configuration as a string for demonstration purposes
        String securityFormLoginConfig = "<security:form-login login-page=\"/login\" default-target-url=\"/app/start\" " +
                "authentication-failure-url=\"/login/failure\" username-parameter=\"username\" " +
                "password-parameter=\"password\" always-use-default-target=\"true\" />";

        System.out.println(securityFormLoginConfig);
    }
}