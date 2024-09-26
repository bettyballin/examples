public class Temp671 {
    public static void main(String[] args) {
        System.out.println("<VirtualHost www.mysite.com:80>");
        System.out.println("    RewriteEngine on");
        System.out.println("    RewriteCond %{HTTP_HOST} www\\.mysite\\.com");
        System.out.println("    RewriteRule ^/(.*)$ ajp://localhost:8009/myapp/$1 [P,QSA,L]");
        System.out.println("</VirtualHost>");
    }
}