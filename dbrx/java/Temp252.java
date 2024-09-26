Here is the corrected Java code:


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.iv.RandomIVGenerator;
import org.jasypt.encryption.pbe.config.StandardPBECipherConfig;

import java.security.Security;
import java.security.Provider;

public class Temp252 {
    public static void main(String[] args) {

        Security.addProvider(new BouncyCastleProvider());

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setProviderName("BC"); // Use "BC" instead of new BouncyCastleProvider()
        encryptor.setPassword("your_password");
        encryptor.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        encryptor.setKeyObtentionIterations(1000);
        encryptor.setPoolSize(4);

        StandardPBECipherConfig cipherConfig = new StandardPBECipherConfig();
        cipherConfig.setCipherAlgorithm("AES/GCM/NoPadding");
        cipherConfig.setIvGenerator(new RandomIVGenerator());
        cipherConfig.setSaltGenerator(new RandomSaltGenerator()); // Use new instead of setSaltGeneratorName

        encryptor.setConfig(cipherConfig);

        // Example encryption and decryption
        String message = "Hello, World!";
        String encryptedMessage = encryptor.encrypt(message);
        String decryptedMessage = encryptor.decrypt(encryptedMessage);

        System.out.println("Original message: " + message);
        System.out.println("Encrypted message: " + encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}


`pom.xml` or equivalent build file remains the same. 

xml
<dependencies>
    <dependency>
        <groupId>org.jasypt</groupId>
        <artifactId>jasypt</artifactId>
        <version>1.9.3</version>
    </dependency>
    <dependency>
        <groupId>org.bouncycastle</groupId>
        <artifactId>bcprov-jdk15on</artifactId>
        <version>1.69</version>
    </dependency>
</dependencies>