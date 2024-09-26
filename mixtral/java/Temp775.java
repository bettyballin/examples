import org.bouncycastle.asn1.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Temp775 {
    public static void main(String[] args) {
        // Sample usage of the decodeDERValue method
        // This part of the code should be adjusted based on how you obtain the DerValue instance
    }

    public static String decodeDERValue(DEREncodable derValue) throws IOException {
        ASN1InputStream asnInput = new ASN1InputStream(new ByteArrayInputStream(derValue.getDEREncoded()));

        Object obj = asnInput.readObject();

        if (obj instanceof DERPrintableString ||
            obj instanceof DERUTF8String     ||
            obj instanceof DERIA5String) {
                return ((DERString) obj).getString();
        }

        throw new IOException("Unsupported type: " + obj.getClass().getName());
    }
}