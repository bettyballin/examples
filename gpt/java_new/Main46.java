import org.mindrot.jbcrypt.BCrypt;

public class Main46 {

    public static void main(String[] args) {
        String candidate = "123";
        String storedHash = "$2a$10$pcR4SaZd3PMD/nXQKMssxupMLncDoFwfU7avg/wdpLVChNqGOXbLu";

        if (BCrypt.checkpw(candidate, storedHash)) {
            System.out.println("It matches");
        } else {
            System.out.println("It does not match");
        }
    }
}