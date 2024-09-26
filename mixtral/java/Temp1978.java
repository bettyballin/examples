import org.bouncycastle.crypto.generators.SCrypt;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KdfParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Arrays;

public class Temp1978 {
    public static void main(String[] args) throws Exception {
        byte[] privateKey = "testPrivateKey".getBytes();
        char[] password = "testPassword".toCharArray();

        byte[] encryptedPrivateKey = encryptPrivateKey(privateKey, password);
        System.out.println(Arrays.toString(encryptedPrivateKey));
    }

    public static byte[] encryptPrivateKey(byte[] privateKey, char[] password) throws Exception {
        // Generate random salt and IV
        SecureRandom secureRandom = new SecureRandom();

        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        IvParameterSpec iv = new IvParameterSpec(new byte[12]);

        // Derive key material using Scrypt
        int N = 32768;
        int r = 8;
        int p = 4;

        byte[] keyMaterial = SCrypt.generate(password.toString().getBytes(), salt, N, r, p, 32);

        // Derive AES-GCM secret key using HKDF
        Mac hmacSha512 = Mac.getInstance("HmacSHA512");
        hmacSha512.init(new KeyParameter(keyMaterial));

        byte[] info = "AES GCM".getBytes();

        byte[] okm = new byte[32];
        hmacSha512.update(info);
        hmacSha512.doFinal(okm, 0);

        SecretKey aesKey = new javax.crypto.spec.SecretKeySpec(okm, "AES");

        // Encrypt the private key using AES-GCM
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, iv.getIV());

        cipher.init(Cipher.ENCRYPT_MODE, aesKey, gcmParameterSpec);
        return cipher.doFinal(privateKey);
    }
}