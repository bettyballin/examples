public class Temp653 {
    public static void main(String[] args) {
        System.out.println("Security constraint and login config example:");
        System.out.println("<security-constraint>");
        System.out.println("    <web-resource-collection>");
        System.out.println("        <web-resource-name>All Access</web-resource-name>");
        System.out.println("        <url-pattern>/*</url-pattern>");
        System.out.println("        <http-method>DELETE</http-method>");
        System.out.println("        <http-method>PUT</http-method>");
        System.out.println("        <http-method>HEAD</http-method>");
        System.out.println("        <http-method>OPTIONS</http-method>");
        System.out.println("        <http-method>TRACE</http-method>");
        System.out.println("        <http-method>GET</http-method>");
        System.out.println("        <http-method>POST</http-method>");
        System.out.println("    </web-resource-collection>");
        System.out.println("    <user-data-constraint>");
        System.out.println("        <transport-guarantee>CONFIDENTIAL</transport-guarantee>");
        System.out.println("    </user-data-constraint>");
        System.out.println("</security-constraint>");
        System.out.println("<login-config>");
        System.out.println("    <auth-method>BASIC</auth-method>");
        System.out.println("    <realm-name>ApplicationRealm</realm-name>");
        System.out.println("</login-config>");
        System.out.println("<security-role>");
        System.out.println("    <role-name>user</role-name>");
        System.out.println("</security-role>");
    }
}