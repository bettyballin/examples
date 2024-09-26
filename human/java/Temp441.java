import org.apache.axis.components.net.SocketFactory;
import org.apache.axis.components.net.SunFakeTrustSocketFactory;

public class Temp441 {
    public static void main(String[] args) {
        try {
            SocketFactory factory = (SocketFactory) Class.forName("org.apache.axis.components.net.SunFakeTrustSocketFactory").newInstance();
            System.setProperty("axis.socketSecureFactory", factory.getClass().getName());
            System.out.println("Property set successfully.");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}