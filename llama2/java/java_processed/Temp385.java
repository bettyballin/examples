import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.util.encoders.Hex;

public class Temp385 {
    public static void main(String[] args) {
        byte[] ipAddressBytes = Hex.decode("7F000001");
        GeneralName ipAddress = new GeneralName(GeneralName.iPAddress, ipAddressBytes);
        System.out.println(ipAddress);
    }
}