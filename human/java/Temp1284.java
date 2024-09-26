public class Temp1284 {
    public static void main(String[] args) {
        System.out.println("<session-config>");
        System.out.println("    <cookie-config>");
        System.out.println("        <!-- browser will disallow JavaScript access to session cookie -->");
        System.out.println("        <http-only>true</http-only>");
        System.out.println("    </cookie-config>");
        System.out.println("    <tracking-mode>COOKIE</tracking-mode>");
        System.out.println("</session-config>");
    }
}