import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import java.io.IOException;

public class Temp1749 {

    public static void main(String[] args) throws IOException {
        // Simulate a response for demonstration purposes
        HttpServletResponse response = new MockHttpServletResponse();
        Object SOME_OBJECT_HERE = new SomeObject("example data");

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(JsonUtil.toJson(SOME_OBJECT_HERE));
    }

    // Mock HttpServletResponse to simulate real behavior
    private static class MockHttpServletResponse implements HttpServletResponse {
        // Implement necessary methods here
        // ...

        @Override
        public void setStatus(int sc) {
            System.out.println("Status set to: " + sc);
        }

        @Override
        public void setContentType(String type) {
            System.out.println("Content type set to: " + type);
        }

        @Override
        public java.io.PrintWriter getWriter() {
            return new java.io.PrintWriter(System.out);
        }

        // Implement other methods as needed
        // ...
    }

    // Mock JsonUtil to convert object to JSON string
    private static class JsonUtil {
        public static String toJson(Object object) {
            // Simple JSON conversion for demonstration. Use a library like Jackson or Gson in real applications.
            return "{\"data\":\"" + ((SomeObject) object).data + "\"}";
        }
    }

    // Mock object for demonstration purposes
    private static class SomeObject {
        public String data;

        public SomeObject(String data) {
            this.data = data;
        }
    }
}