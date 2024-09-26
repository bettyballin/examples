import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class Temp365 {
    public static void main(String[] args) {
        // Example usage of BouncyCastle classes

        // Key for HMAC
        byte[] key = "secretKey".getBytes();
        // Data to be hashed
        byte[] data = "important data".getBytes();

        // Initialize HMAC with SHA-256
        Mac hmac = new HMac(new SHA256Digest());
        CipherParameters keyParam = new KeyParameter(key);
        hmac.init(keyParam);

        // Process the data
        hmac.update(data, 0, data.length);

        // Get the output (HMAC value)
        byte[] output = new byte[hmac.getMacSize()];
        hmac.doFinal(output, 0);

        // Print the HMAC value in hexadecimal format
        System.out.println(bytesToHex(output));
    }

    // Method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}