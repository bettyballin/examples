import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.ECPointUtil;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.jce.ECNamedCurveTable;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ECPointECDHDeserializer extends JsonDeserializer<ECPointECDH> {

    @Override
    public ECPointECDH deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        byte[] x10 = node.get("-2").binaryValue();
        byte[] y10 = node.get("-3").binaryValue();

        ECNamedCurveParameterSpec params = ECNamedCurveTable.getParameterSpec("secp256r1");
        ECCurve curve = params.getCurve();

        ECPoint point = curve.decodePoint(Hex.decode("04" + Utils.convertBytesToHex(x10) + Utils.convertBytesToHex(y10)));

        return new ECPointECDH(point);
    }
}