import java.util.Optional;

public class Temp808 {
    public static void main(String[] args) {
        // Simulate the request and cookies
        Request request = new Request();
        
        // Get the PLAY_FLASH cookie value if present
        Optional<String> error = request.getCookies().get("PLAY_FLASH");
        
        // Optional: Print the error value if present
        error.ifPresent(System.out::println);
    }
}

// Simulate a Request class for the example
class Request {
    private Cookies cookies = new Cookies();
    
    public Cookies getCookies() {
        return cookies;
    }
}

// Simulate a Cookies class for the example
class Cookies {
    private java.util.Map<String, String> cookieMap = new java.util.HashMap<>();
    
    public Cookies() {
        // Add a sample cookie for the example
        cookieMap.put("PLAY_FLASH", "SampleFlashValue");
    }
    
    public Optional<String> get(String key) {
        return Optional.ofNullable(cookieMap.get(key));
    }
}