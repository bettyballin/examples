import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayOutputStream;
import java.util.zip.DeflaterOutputStream;

public class EncryptionService {
    private Cipher cipher;
    private byte[] skey;
    private byte[] iv;

    public EncryptionService(Cipher cipher, byte[] skey, byte[] iv) {
        this.cipher = cipher;
        this.skey = skey;
        this.iv = iv;
    }

    public byte[] encrypt(byte[] data) {
        try {
            ByteArrayOutputStream deflatedOutput = new ByteArrayOutputStream();
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(deflatedOutput);
            deflaterOutputStream.write(data);
            deflaterOutputStream.close();
            byte[] deflatedData = deflatedOutput.toByteArray();

            cipher.init(Cipher.ENCRYPT_MODE, skey, new IvParameterSpec(iv));
            return cipher.doFinal(deflatedData);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}