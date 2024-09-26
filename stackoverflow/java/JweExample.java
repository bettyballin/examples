import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.JoseException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

public class JweExample {
    public static void main(String[] args) {
        try {
            String shared_secret = "LyQnklSrxsk3Ch2+AHi9HoDW@//x1LwM123QP/ln";
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(shared_secret.getBytes("UTF-8"));

            JsonWebEncryption jwe = new JsonWebEncryption();
            jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A256GCMKW);
            jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_256_GCM);
            jwe.setKey(new AesKey(digest));
            jwe.setPayload("some important content to be encrypted and integrity protected");

            String serializedJwe = jwe.getCompactSerialization();
            System.out.println("JWE compact serialization: " + serializedJwe);

            JsonWebEncryption receiverJwe = new JsonWebEncryption();
            receiverJwe.setCompactSerialization(serializedJwe);
            receiverJwe.setKey(new AesKey(digest));

            String plaintext = receiverJwe.getPlaintextString();
            System.out.println("plaintext: " + plaintext);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | JoseException e) {
            e.printStackTrace();
        }
    }
}