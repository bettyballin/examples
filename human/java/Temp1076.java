public class Temp1076 {
    public static void main(String[] args) {
        System.out.println("<security:http auto-config=\"true\" use-expressions=\"true\">");
        System.out.println("    <security:intercept-url pattern=\"/login*\" access=\"isAnonymous()\" />");
        System.out.println("</security:http>");
    }
}