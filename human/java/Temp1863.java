public class SecurityHeaders {

    public static void main(String[] args) {
        System.out.println("Cache-Control: no-cache, no-store, max-age=0, must-revalidate");
        System.out.println("Pragma: no-cache");
        System.out.println("Expires: 0");
        System.out.println("X-Content-Type-Options: nosniff");
        System.out.println("Strict-Transport-Security: max-age=31536000 ; includeSubDomains");
        System.out.println("X-Frame-Options: DENY");
        System.out.println("X-XSS-Protection: 1; mode=block");
    }
}