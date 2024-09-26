import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

public class HMacExample {
    public static void main(String[] args) {
        HMac hmac = new HMac(new SHA256Digest());
        hmac.init(new KeyParameter(new byte[0]));
        byte[] message = new byte[] {}; // empty message
        hmac.update(message, 0, message.length);
        byte[] out = new byte[hmac.getMacSize()];
        hmac.doFinal(out, 0);

        // Use the HMAC 'out' as needed
    }
}