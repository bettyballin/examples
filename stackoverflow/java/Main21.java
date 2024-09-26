import org.apache.axis.AxisProperties;

public class Main21 {
    public static void main(String[] args) {
        AxisProperties.setProperty("axis.socketSecureFactory", "org.apache.axis.components.net.SunFakeTrustSocketFactory");
    }
}