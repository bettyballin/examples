import java.net.http.HttpHeaders;

public class Temp960 {
    public static void main(String[] args) {
        // Mock example of request header retrieval
        MockRequest request = new MockRequest();
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("Authorization Header: " + authHeader);
    }
}

// Mock class to simulate request object
class MockRequest {
    public String getHeader(String name) {
        if (name.equals(HttpHeaders.AUTHORIZATION)) {
            return "Bearer some-token";
        }
        return null;
    }
}