import java.security.*;
import java.security.spec.*;
import java.util.Arrays;
import javax.crypto.*;

public class Temp1381 {
    public static void main(String[] args) {
        byte[] w = new byte[] { 0x04, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, (byte) 0xE5, (byte) 0xF6 };
        try {
            ECPublicKey publicKey = generateP256PublicKeyFromUncompressedW(w);
            System.out.println("Generated EC Public Key: " + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts an uncompressed secp256r1 / P-256 public point to the EC public key it is representing.
     * @param w a 64 byte uncompressed EC point starting with <code>04</code>
     * @return an <code>ECPublicKey</code> that the point represents 
     */
    public static ECPublicKey generateP256PublicKeyFromUncompressedW(byte[] w) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        if (w[0] != 0x04) {
            throw new InvalidKeySpecException("w is not an uncompressed key");
        }
        return generateP256PublicKeyFromFlatW(Arrays.copyOfRange(w, 1, w.length));
    }

    public static ECPublicKey generateP256PublicKeyFromFlatW(byte[] w) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        ECPoint point = new ECPoint(
            new BigInteger(1, Arrays.copyOfRange(w, 0, 32)),
            new BigInteger(1, Arrays.copyOfRange(w, 32, 64))
        );
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256r1");
        ECPublicKeySpec pubSpec = new ECPublicKeySpec(point, ecSpec);

        KeyFactory k