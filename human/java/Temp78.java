import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.util.encoders.Hex;

public class Temp78 {
    public static void main(String[] args) {
        try {
            byte[] derOctetString = Hex.decode("030205A0"); // Example DER encoded byte array for KeyUsage

            ASN1InputStream ais = new ASN1InputStream(derOctetString);
            KeyUsage ku = new KeyUsage((DERBitString) ais.readObject());

            // Output the KeyUsage object to ensure it's read correctly
            System.out.println("KeyUsage: " + ku);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}