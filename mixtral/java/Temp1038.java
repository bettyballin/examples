import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.AesKeyWrapManagementAlgorithm;
import org.jose4j.jwe.DirectEncrypter;
import org.jose4j.jwe.AesGcmContentEncryptionAlgorithm;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.StringUtil;
import org.jose4j.base64url.Base64Url;

import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp1038 {
    public static void main(String[] args) {
        try {
            JsonWebEncryption jwe = new JsonWebEncryption();
            jwe.setPayload("Hello World!");

            // Create the CEK
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey cek = keyGen.generateKey();

            // Encrypt with AEAD
            jwe.setAlgorithmHeaderValue("dir");
            jwe.setEncryptionMethodHeaderParameter("A256GCM");

            // Set the IV
            SecureRandom random = new SecureRandom();
            byte[] iv = new byte[12]; // IV size for AES GCM is 12 bytes
            random.nextBytes(iv);
            jwe.setHeader("iv", Base64Url.encode(iv));

            // Encrypt
            DirectEncrypter encrypter = new DirectEncrypter(cek);
            jwe.setContentEncryptionAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST, AesGcmContentEncryptionAlgorithm.A256GCM.getAlgorithmIdentifier()));
            jwe.setKey(cek);
            jwe.setEncryptionKey(cek);

            String serializedJWE = jwe.getCompactSerialization();
            System.out.println("Serialized JWE: " + serializedJWE);

        } catch (JoseException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}