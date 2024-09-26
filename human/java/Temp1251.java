import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp1251 {

    private byte[] sharedKey = new byte[16]; // Initialize with appropriate value
    private byte[] ivMac = new byte[16]; // Initialize with appropriate value
    private byte[] ivHotp = new byte[16]; // Initialize with appropriate value
    private byte[] macKey = new byte[16]; // Initialize with appropriate value
    private Cipher cipher;
    private Mac mac;

    public Temp1251() throws Exception {
        this.cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        this.mac = Mac.getInstance("HmacSHA256");
        this.mac.init(new SecretKeySpec(macKey, "HmacSHA256"));
    }

    public static void main(String[] args) {
        try {
            Temp1251 temp = new Temp1251();
            temp.encryptSingleSecret("123456", "aabbccddeeff00112233445566778899");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] concatByteArrays(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public void encryptSingleSecret(String serialNo, String secret) {
        try {
            byte[] secretBytes = hexStr2Bytes(secret);

            // First, encrypt the MAC key
            IvParameterSpec cipherParamSpec = new IvParameterSpec(this.ivMac);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(this.sharedKey, "AES"), cipherParamSpec);
            byte[] encryptedMacKey = cipher.doFinal(this.macKey);

            // Now, prepend the IV used to encrypt the mac key to the cipher
            byte[] toBeBase64Encoded = concatByteArrays(this.ivMac, encryptedMacKey);

            // Now base64-encode the result and print it out. This is for the <MACKey> element
            System.out.println("<MACKey><CipherValue>: " + Base64.getEncoder().encodeToString(toBeBase64Encoded));

            // Next, encrypt the secret
            cipherParamSpec = new IvParameterSpec(this.ivHotp);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(this.sharedKey, "AES"), cipherParamSpec);
            byte[] encryptedSecret = cipher.doFinal(secretBytes);

            // Now, prepend the IV used to encrypt the secret to the cipher
            toBeBase64Encoded = concatByteArrays(this.ivHotp, encryptedSecret);

            // Now base64-encode the result and print it out. This is for the <Data> element
            System.out.println("<Data><Secret><CipherValue>: " + Base64.getEncoder().encodeToString(toBeBase64Encoded));

            // Finally, compute the MAC over the encrypted value
            byte[] macValue = this.mac.doFinal(toBeBase64Encoded);

            // Base64-encode the result and print it out. This is for the ValueMAC element
            System.out.println("<Data><Secret><ValueMAC>: " + Base64.getEncoder().encodeToString(macValue));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private byte[] hexStr2Bytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}