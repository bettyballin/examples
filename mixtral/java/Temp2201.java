import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.util.encoders.Hex;

public class Temp2201 {
    public static void main(String[] args) {
        byte[] secret = "supersecretkey".getBytes();
        byte[] derivedKey = deriveAes256bitKey(secret);
        System.out.println(Hex.toHexString(derivedKey));
    }

    private static byte[] deriveAes256bitKey(byte[] secret) {
        HKDFBytesGenerator hkdf = new HKDFBytesGenerator(new SHA3Digest());

        // Set the input key material (IKM) with null salt and info.
        hkdf.init(new HKDFParameters(secret, null, null));

        byte[] derivedKey = new byte[256 / Byte.SIZE];

        // Derive a 256-bit AES key using HKDF
        hkdf.generateBytes(derivedKey, 0, derivedKey.length);

        return derivedKey;
    }
}