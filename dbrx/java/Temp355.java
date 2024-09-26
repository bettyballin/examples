import org.mindrot.jbcrypt.BCrypt;

public class Temp355 {
    public static void main(String[] args) {
        String plaintextPassword = "myPassword123";
        String hashedPassword = BCrypt.hashpw(plaintextPassword, BCrypt.gensalt());

        boolean passwordMatch = BCrypt.checkpw(plaintextPassword, hashedPassword);

        System.out.println("Password match: " + passwordMatch);
    }
}
// Add the following dependency in your pom.xml file if you are using Maven
// <dependency>
//     <groupId>org.mindrot</groupId>
//     <artifactId>jbcrypt</artifactId>
//     <version>0.4</version>
// </dependency>

// Or add the following dependency in your build.gradle file if you are using Gradle
// implementation 'org.mindrot:jbcrypt:0.4'