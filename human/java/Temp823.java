public class Temp823 {
    public static void main(String[] args) {
        System.out.println("<VirtualHost *:80>");
        System.out.println("   ServerName dev.bo.MYDOMAIN.com");
        System.out.println("   ProxyPass / ajp://localhost:20009/bo/");
        System.out.println("   ProxyPassReverse / ajp://localhost:20009/bo/");
        System.out.println("   ProxyPass /bo ajp://localhost:20009/bo/");
        System.out.println("   ProxyPassReverse /bo ajp://localhost:20009/bo/");
        System.out.println("   ProxyPassReverseCookiePath /bo/ /");
        System.out.println("</VirtualHost>");
    }
}