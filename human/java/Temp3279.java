import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.DHParameterSpec;
import java.util.Base64;

public class Temp3279 {

    private static ByteBuffer der(int tag, ByteBuffer val) {
        int len = val.remaining();
        ByteBuffer enc = ByteBuffer.allocate(4);
        enc.put((byte) tag);
        if (len < 128) {
            enc.put((byte) len);
            enc.flip();
            enc.limit(2);
        } else if (len < 256) {
            enc.put((byte) 0x81);
            enc.put((byte) len);
            enc.flip();
            enc.limit(3);
        } else {
            enc.put((byte) 0x82);
            enc.put((byte) (len >> 8));
            enc.put((byte) (len & 0xFF));
            enc.flip();
        }
        ByteBuffer result = ByteBuffer.allocate(enc.remaining() + val.remaining());
        result.put(enc);
        result.put(val);
        result.flip();
        return result;
    }

    private static ByteBuffer derpint(ByteBuffer x) {
        if (x.get(0) < 128) {
            return der(0x02, x);
        } else {
            ByteBuffer onezero = ByteBuffer.allocate(1).put((byte) 0).flip();
            return der(0x02, ByteBuffer.allocate(onezero.remaining() + x.remaining()).put(onezero).put(x).flip());
        }
    }

    private static ByteBuffer derseq(ByteBuffer... x) {
        int totalLength = 0;
        for (ByteBuffer b : x) {
            totalLength += b.remaining();
        }
        ByteBuffer concatenated = ByteBuffer.allocate(totalLength);
        for (ByteBuffer b : x) {
            concatenated.put(b);
        }
        concatenated.flip();
        return der(0x30, concatenated);
    }

    public static void main(String[] args) throws Exception {
        byte[] oidpkcs3 = Base64.getDecoder().decode("BgkqhkiG9w0BAQEw");

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
        DHParameterSpec dhSpec = new DHParameterSpec(new java.math.BigInteger("FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E08A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A63A3620FFFFFFFFFFFFFFFF", 16), new java.math.BigInteger("2"));
        kpg.initialize(dhSpec);
        KeyPair kp = kpg.generateKeyPair();

        PublicKey pubKey = kp.getPublic();
        byte[] pubKeyEnc = pubKey.getEncoded();
        ByteBuffer pubKeyBuffer = ByteBuffer.wrap(pubKeyEnc);

        ByteBuffer pBuffer = ByteBuffer.wrap(dhSpec.getP().toByteArray());
        ByteBuffer gBuffer = ByteBuffer.wrap(dhSpec.getG().toByteArray());

        ByteBuffer algid = derseq(ByteBuffer.wrap(oidpkcs3), derseq(derpint(pBuffer), derpint(gBuffer)));
        ByteBuffer spki = derseq(algid, der(0x03, ByteBuffer.allocate(1).put((byte) 0).flip().put(pubKeyBuffer).flip()));

        System.out.println(Base64.getEncoder().encodeToString(spki.array()));
    }
}