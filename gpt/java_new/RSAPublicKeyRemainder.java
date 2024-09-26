import org.bouncycastle.crypto.params.RSAKeyParameters;

import java.math.BigInteger;
import java.nio.ByteBuffer;

public class RSAPublicKeyRemainder {

    public static byte[] getIssuerPublicKeyRemainder(RSAKeyParameters publicKey, int nCA, int nI) {
        BigInteger modulus = publicKey.getModulus();
        byte[] modulusBytesArray = modulus.toByteArray();
        ByteBuffer modulusBytes = ByteBuffer.wrap(modulusBytesArray);

        if (modulusBytesArray[0] == 0) {
            modulusBytes.get();
        }

        int modulusLength = modulusBytes.remaining();
        int leftmostDigitsLength = nCA - 36;
        int remainderLength = nI - leftmostDigitsLength;

        if (remainderLength <= 0 || remainderLength > modulusLength) {
            throw new IllegalArgumentException("Invalid length parameters");
        }

        byte[] remainder = new byte[remainderLength];
        modulusBytes.position(modulusLength - remainderLength);
        modulusBytes.get(remainder);

        return remainder;
    }
}