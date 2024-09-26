import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Main {
    public static void main(String[] args) {
        // Add BouncyCastle provider
        Security.addProvider(new BouncyCastleProvider());
        
        // Your code logic here
        System.out.println("BouncyCastle provider added successfully!");
    }
}
// Add BouncyCastle library to classpath
// If using Maven, add the following dependency to pom.xml:
// <dependency>
//     <groupId>org.bouncycastle</groupId>
//     <artifactId>bcprov-jdk15on</artifactId>
//     <version>1.70</version>
// </dependency>