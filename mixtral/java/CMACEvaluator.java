import org.bouncycastle.crypto.*;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;
import java.util.Arrays;

public class CMACEvaluator {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        byte[] key = new byte[]{
            (byte) 0x2B, (byte) 0x7E, (byte) 0x15, (byte) 0x16, 
            (byte) 0x28, (byte) 0xAE, (byte) 0xD2, (byte) 0xA6, 
            (byte) 0xAB, (byte) 0xF7, (byte) 0x4E, (byte) 0x21, 
            (byte) 0x82, (byte) 0x88, (byte) 0x9C, (byte) 0xD6
        }; // Example AES-128 bit Key

        CipherParameters params = new KeyParameter(key);

        BlockCipher aesEngine = new AESFastEngine();

        Mac cmac = new CMac(aesEngine);

        byte[] dataToAuthenticate = "Hello World".getBytes("UTF-8");

        // Initialize the MAC
        cmac.init(params);

        // Update with input
        cmac.update(dataToAuthenticate, 0, dataToAuthenticate.length);

        byte[] authenticationTag = new byte[cmac.getMacSize()];

        // Finalize and get the MAC
        cmac.doFinal(authenticationTag, 0);

        System.out.println("CMAC: " + bytesToHex(authenticationTag));
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}