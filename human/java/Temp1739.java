import java.net.InetAddress;
import java.net.UnknownHostException;

public class Temp1739 {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("136.147.59.44");
            System.out.println("Host name: " + inetAddress.getHostName());
            System.out.println("Canonical Host name: " + inetAddress.getCanonicalHostName());
        } catch (UnknownHostException e) {
            System.err.println("Unable to lookup the host: " + e.getMessage());
        }
    }
}