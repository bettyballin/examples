import javax.servlet.http.Cookie;

public class Temp2062 {
    public static void main(String[] args) {
        // Mock request with cookies for demonstration purposes
        Cookie[] mockCookies = {
            new Cookie("cookie1", "value1"),
            new Cookie("cookie2", "value2")
        };
        
        // Simulate request.getCookies() with mock data
        for (Cookie cookie : mockCookies) {
            cookie.setMaxAge(0);
            System.out.println("Cookie " + cookie.getName() + " is set to expire.");
        }
    }
}