import javax.servlet.http.Cookie;

public class Temp2896 {
    public static void main(String[] args) {
        // Example of invalidating a session and deleting a cookie
        // This typically would be part of a web application and handled in a servlet
        
        // Simulate session invalidation
        System.out.println("Session invalidated.");

        // Simulate deleting JSESSIONID cookie
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        System.out.println("Cookie 'JSESSIONID' deleted.");
    }
}