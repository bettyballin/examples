import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReverseDNSLookup {
    public static void main(String[] args) {
        String ipAddress = "54.203.56.245";
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            String hostName = inetAddress.getCanonicalHostName();
            System.out.println("IP Address: " + ipAddress);
            System.out.println("Domain Name: " + hostName);
        } catch (UnknownHostException e) {
            System.out.println("Host not found: " + e.getMessage());
        }
    }
}