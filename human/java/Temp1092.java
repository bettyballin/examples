import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String pack = "your/package/name/";
        String signCertName = "your_certificate_name";
        
        InputStream signCertIn = Main.class.getClassLoader().getResourceAsStream(pack + signCertName + ".cer");
        
        if (signCertIn != null) {
            System.out.println("Certificate loaded successfully.");
        } else {
            System.out.println("Failed to load certificate.");
        }
    }
}