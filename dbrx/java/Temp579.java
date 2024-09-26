import org.bouncycastle.asn1.*;
import org.bouncycastle.util.encoders.Hex;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Temp579 {
    public static void main(String[] args) {
        // Example usage here
    }

    public static String decodeDERValue(DerValue derValue) throws IOException {
        ASN1InputStream asnInput = new ASN1InputStream(new ByteArrayInputStream(derValue.toByteArray()));
        ASN1Primitive obj = asnInput.readObject();
        String result = "";

        if (obj instanceof DERPrintableString || obj instanceof DERUTF8String || obj instanceof DERIA5String) {
            DEROctetString octets = (DEROctetString) obj;
            byte[] decodedBytes = Hex.decode(octets.getOctets());
            result = new String(decodedBytes, StandardCharsets.UTF_8);
        } else if (obj instanceof ASN1Sequence || obj instanceof ASN1Set) {
            // Handle nested structures recursively
            for (ASN1Encodable enc : ((ASN1Sequence) obj).toArray()) {
                result += decodeDERValue(new DerValue(enc.toASN1Primitive().getEncoded()));
            }
        }

        asnInput.close();
        return result.trim();
    }

    // Dummy DerValue class for demonstration purposes
    static class DerValue {
        private byte[] value;

        public DerValue(byte[] value) {
            this.value = value;
        }

        public byte[] toByteArray() {
            return value;
        }
    }
}