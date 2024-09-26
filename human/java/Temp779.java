public class Temp779 {
    public static void main(String[] args) {
        System.out.println("<intercept-url pattern=\"/home.jsp\" access=\"permitAll\" />");
        System.out.println("<intercept-url pattern=\"/*\" access=\"isAuthenticated()\" />");
    }
}