import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

public class Temp2841 {
    public static void main(String[] args) {
        // Initialize HMAC with SHA-256 digest
        HMac hmac = new HMac(new SHA256Digest());
        hmac.init(new KeyParameter(new byte[0]));
        
        // Define the message
        byte[] message = "your message".getBytes();
        
        // Update the HMAC with the message
        hmac.update(message, 0, message.length);
        
        // Finalize the HMAC computation
        byte[] out = new byte[hmac.getMacSize()];
        hmac.doFinal(out, 0);
        
        // Print the HMAC output
        for (byte b : out) {
            System.out.format("%02x", b);
        }
    }
}