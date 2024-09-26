public class Temp909 {
    public static void main(String[] args) {
        System.out.println("<http auto-config=\"true\" use-expressions=\"true\">");
        System.out.println("    <intercept-url pattern=\"/singin\" filters=\"none\" />");
        System.out.println("    <intercept-url pattern=\"/css/**\" filters=\"none\" />");
        System.out.println("    <intercept-url pattern=\"/sign\" access=\"isAnonymous()\" />");
        System.out.println("    <intercept-url pattern=\"/signup\" access=\"isAnonymous()\" />");
        System.out.println("    <intercept-url pattern=\"/panel/signin\" access=\"isAnonymous()\" />");
        System.out.println("    <intercept-url pattern=\"/singout\" access=\"permitAll\" />");
        System.out.println("    <intercept-url pattern=\"/panel/**\" access=\"hasRole(ROLE_USER)\" />");
        System.out.println("    <intercept-url pattern=\"/**\" access=\"isAuthenticated()\" />");
        System.out.println("    <form-login login-page=\"/signin\" default-target-url=\"/home\" authentication-failure-url=\"/signin\" />");
        System.out.println("    <logout logout-success-url=\"/logout\" />");
        System.out.println("</http>");
    }
}