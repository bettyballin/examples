public class Temp1750 {
    public static void main(String[] args) {
        System.out.println("Security configuration example:");
        System.out.println("<security:http xmlns=\"http://www.springframework.org/schema/security\">");
        System.out.println("  <intercept-url pattern=\"/\" access=\"permitAll()\"/>");
        System.out.println("  <anonymous/>");
        System.out.println("  <csrf disabled=\"true\"/>");
        System.out.println("</security:http>");
    }
}