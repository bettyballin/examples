import java.security.Security;

public class Temp2009 {
    public static void main(String[] args) {
        System.setProperty("com.sun.net.ssl.checkRevocation", "true");
        Security.setProperty("ocsp.enable", "true");
    }
}