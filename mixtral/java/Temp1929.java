import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import java.math.BigInteger;

public class Temp1929 {
    public static void main(String[] args) {
        // Replace "your_value" with an actual numeric string
        String yourValue = "12345678901234567890123456789012";
        BigInteger bigIntValue = new BigInteger(yourValue, 10);
        
        X9IntegerConverter converter = new X9IntegerConverter();
        ASN1OctetString octetString = new DEROctetString(converter.integerToBytes(bigIntValue, 32));
        byte[] xBytes = octetString.getOctets();

        // Print the byte array for verification
        for(byte b : xBytes) {
            System.out.printf("%02x ", b);
        }
    }
}