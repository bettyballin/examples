import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;

public class Temp298 {
    public static void main(String[] args) {
        PaddedBufferedBlockCipher c = new PaddedBufferedBlockCipher(new RijndaelEngine(256), new PKCS7Padding());
        System.out.println("Cipher initialized successfully");
    }
}