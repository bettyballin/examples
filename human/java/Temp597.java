public class Temp597 {
    public static void main(String[] args) {
        System.out.println("<security-constraint>");
        System.out.println("    <web-resource-collection>");
        System.out.println("      <web-resource-name>any-resource</web-resource-name>");
        System.out.println("      <url-pattern>/emailcontroller</url-pattern>");
        System.out.println("    </web-resource-collection>");
        System.out.println("    <auth-constraint>");
        System.out.println("      <role-name>admin</role-name>");
        System.out.println("    </auth-constraint>");
        System.out.println("    <user-data-constraint>");
        System.out.println("      <transport-guarantee>CONFIDENTIAL</transport-guarantee>");
        System.out.println("    </user-data-constraint>");
        System.out.println("</security-constraint>");
    }
}