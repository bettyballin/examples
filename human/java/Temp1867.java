public class Temp1867 {
    public static void main(String[] args) {
        String pattern = "/admin/**";
        String access = "ROLE_ADMIN";

        System.out.println("<http pattern=\"" + pattern + "\">");
        System.out.println("    <intercept-url pattern='/**' access='" + access + "' />");
        System.out.println("</http>");
    }
}