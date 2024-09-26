import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp3349 {
    public static void main(String[] args) {
        String password = "secret password";
        byte[] salt = Base64.getDecoder().decode("AAAAAAAAAAAAAAAAAAAAAA==");

        System.out.println("encryptionKeyArgon2id (Base64) minimal: " + generateKey(password, salt, Argon2Parameters.ARGON2_id, 2, 65536, 1));
        System.out.println("encryptionKeyArgon2id (Base64) interactive: " + generateKey(password, salt, Argon2Parameters.ARGON2_id, 3, 327680, 4));
        System.out.println("encryptionKeyArgon2id (Base64) moderate: " + generateKey(password, salt, Argon2Parameters.ARGON2_id, 4, 1048576, 6));
        System.out.println("encryptionKeyArgon2id (Base64) sensitive: " + generateKey(password, salt, Argon2Parameters.ARGON2_id, 6, 16777216, 8));
    }

    private static String generateKey(String password, byte[] salt, int type, int iterations, int memory, int parallelism) {
        Argon2Parameters.Builder builder = new Argon2Parameters.Builder(type)
                .withSalt(salt)
                .withIterations(iterations)
                .withMemoryAsKB(memory)
                .withParallelism(parallelism);

        Argon2BytesGenerator generator = new Argon2BytesGenerator();
        generator.init(builder.build());

        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] result = new byte[32];
        generator.generateBytes(passwordBytes, result);

        return Base64.getEncoder().encodeToString(result);
    }
}


Note: To run this code, you need to include the Bouncy Castle library in your project. You can add it via Maven by including the following dependency in your `pom.xml`:

xml
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcprov-jdk15on</artifactId>
    <version>1.70</version>
</dependency>
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcpkix-jdk15on</artifactId>
    <version>1.70</version>
</dependency>


Or, if you're not using Maven, you can download the JAR files from the Bouncy Castle website and add them to your project manually.