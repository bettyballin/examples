import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;

public class Temp1580 {
    public static void main(String[] args) {
        // This is a placeholder for HttpServletRequest object.
        // In a real scenario, this would be provided by the servlet container.
        HttpServletRequest request = getMockRequest();

        String serverName = request.getHeader("host");
        if (serverName == null || "".equals(serverName)) {
            // No Host header present use the default
            serverName = request.getLocalAddr();
        }

        int port;
        try {
            InetAddress address = InetAddress.getByName(request.getServerName());

            if (address != null) {
                port = address.getHostAddress().equals("127.0.0.1") ? 80 : request.getLocalPort();
                System.out.println("Server Name: " + serverName + ", Port: " + port);
            }
        } catch (UnknownHostException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    // Mock HttpServletRequest for demonstration purposes
    private static HttpServletRequest getMockRequest() {
        return new HttpServletRequest() {
            @Override
            public String getHeader(String name) {
                if ("host".equals(name)) {
                    return "localhost";
                }
                return null;
            }

            @Override
            public String getLocalAddr() {
                return "127.0.0.1";
            }

            @Override
            public String getServerName() {
                return "localhost";
            }

            @Override
            public int getLocalPort() {
                return 8080;
            }

            // You need to implement other methods if required, for simplicity they are omitted here.
        };
    }
}