import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.KeyUsage;

import java.io.IOException;

public class KeyUsageReader {

    public static void main(String[] args) {
        // Assuming derOctetString.getOctetStream() is a method that returns an InputStream
        try (ASN1InputStream ais = new ASN1InputStream(derOctetString.getOctetStream())) {
            KeyUsage ku = KeyUsage.getInstance(ais.readObject());
            // Use the KeyUsage object ku as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}