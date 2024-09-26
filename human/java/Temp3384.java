import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

import java.io.IOException;

public class Temp3384 {

    public static void main(String[] args) throws IOException, JsonProcessingException {
        // Example usage
        String json = "{\"-2\":\"MIGbMBAGByqGSM49AgEGBSuBBAAjA4GGAAQAQf+f4kGVe1R5lXf2l2G+jlbJp2P9UJX2T1vY4eJf\n" +
                "2ZJcZ3hO0/VC3KJ4qY5gpq6nK4V4Xg3tXh7Q==\",\"-3\":\"MIGbMBAGByqGSM49AgEGBSuBBAAjA4GGAAQAQf+f4kGVe1R5lXf2l2G+jlbJp2P9UJX2T1vY4eJf\n" +
                "2ZJcZ3hO0/VC3KJ4qY5gpq6nK4V4Xg3tXh7Q==\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonParser parser = mapper.getFactory().createParser(json);
        DeserializationContext ctxt = mapper.getDeserializationContext();

        Temp3384 temp = new Temp3384();
        ECPointECDH pointECDH = temp.deserialize(parser, ctxt);

        System.out.println(pointECDH.getPoint());
    }

    public ECPointECDH deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.readValueAsTree();

        byte[] x10 = node.get("-2").binaryValue();
        byte[] y10 = node.get("-3").binaryValue();

        String x = Utils.convertBytesToHex(x10);
        String y = Utils.convertBytesToHex(y10);

        ECNamedCurveParameterSpec params = ECNamedCurveTable.getParameterSpec("secp256r1");
        ECCurve curve = params.getCurve();

        ECPoint point = curve.decodePoint(Hex.decode("04" + x + y));

        return new ECPointECDH(point);
    }
}

class Utils {
    public static String convertBytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

class ECPointECDH {
    private final ECPoint point;

    public ECPointECDH(ECPoint point) {
        this.point = point;
    }

    public ECPoint getPoint() {
        return point;
    }
}


Make sure to include the required dependencies for Bouncy Castle and Jackson in your project for the above code to work correctly.