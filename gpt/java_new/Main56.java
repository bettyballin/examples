import javax.net.ssl.SSLContext;

public class Main56 {
    public static void main(String[] args) {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            System.setProperty("javax.net.debug", "all");
            // Additional code to use the sslContext as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}