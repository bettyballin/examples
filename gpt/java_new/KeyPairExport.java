import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.jcajce.JceOpenSSLPKCS8EncryptorBuilder;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;

import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;

public class KeyPairExport {
    public static void main(String[] args) throws Exception {
        // Generate key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateCrtKey privateCrtKey = (RSAPrivateCrtKey) keyPair.getPrivate();

        // Encrypt the private key
        JceOpenSSLPKCS8EncryptorBuilder builder = new JceOpenSSLPKCS8EncryptorBuilder(PKCS8Generator.PBE_SHA1_3DES);
        builder.setPasssword("password".toCharArray());
        builder.setRandom(new SecureRandom());
        builder.setIterationCount(2048);
        
        OutputEncryptor encryptor = builder.build();
        PrivateKeyInfo privateKeyInfo = PrivateKeyInfo.getInstance(privateCrtKey.getEncoded());
        PKCS8EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new PKCS8EncryptedPrivateKeyInfo(privateKeyInfo, encryptor);

        // Write keys to PEM format
        StringWriter stringWriter = new StringWriter();
        JcaPEMWriter pemWriter = new JcaPEMWriter(stringWriter);
        
        // Write the public key
        pemWriter.writeObject(publicKey);
        
        // Write the encrypted private key
        pemWriter.writeObject(encryptedPrivateKeyInfo);
        
        pemWriter.close();
        
        // Final PEM strings
        String publicKeyPEM = stringWriter.toString();
        String privateKeyPEM = stringWriter.toString();

        System.out.println("Public Key PEM format:
" + publicKeyPEM);
        System.out.println("Private Key PEM format:
" + privateKeyPEM);
    }
}