public class Temp195 {
    public static void main(String[] args) {
        System.out.println("<http auto-config=\"false\" use-expressions=\"true\" entry-point-ref=\"loginUrlAuthenticationEntryPoint\">");
        System.out.println("    <security:intercept-url pattern=\"/**\" access=\"isAuthenticated() and permitAll\" />");
        System.out.println("    <custom-filter position=\"FORM_LOGIN_FILTER\" ref=\"absoluteUrlFilter\" />");
        System.out.println("</http>");
    }
}