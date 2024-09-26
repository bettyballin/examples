import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Temp126 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        System.out.println("BouncyCastleProvider added successfully.");
    }
}
// Add the Bouncy Castle library to the classpath
// If using Maven, add this dependency to your pom.xml:
// <dependency>
//     <groupId>org.bouncycastle</groupId>
//     <artifactId>bcprov-jdk15on</artifactId>
//     <version>1.69</version>
// </dependency>