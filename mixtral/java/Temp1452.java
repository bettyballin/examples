import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JceOpenSSLPKCS8EncryptorBuilder;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.pkcs.PKCS8Generator;
import org.bouncycastle.pkcs.jcajce.JcaPKCS8Generator;

import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.interfaces.RSAPrivateCrtKey;

public class Temp1452 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);

        KeyPair pair = keyGen.generateKeyPair();

        JcaPKCS8Generator pkcs8generator = new JcaPKCS8Generator(pair.getPrivate(), null);

        OutputEncryptor encryptor = new JceOpenSSLPKCS8EncryptorBuilder(PKCS8Generator.PBE_SHA1_3DES)
                .setRandom(new SecureRandom())
                .setPasssword("password".toCharArray())
                .build();

        PKCS8EncryptedPrivateKeyInfo encryptedInfo = pkcs8generator.generate(encryptor);

        StringWriter strwriter = new StringWriter();
        try (JcaPEMWriter pw = new JcaPEMWriter(strwriter)) {
            pw.writeObject(encryptedInfo);
        }

        System.out.println(strwriter.toString());
    }
}