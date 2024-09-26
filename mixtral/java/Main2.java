import org.mindrot.jbcrypt.BCrypt;

public class Main {

    public static void main(String[] args) {
        String candidate = "$2a$10$pcR4SaZd3PMD/nXQKMssxupMLncDoFwfU7avg/wdpLVChNqGOXbLu";
        String password = "123";

        if (BCrypt.checkpw(password, candidate)) {
            System.out.println("It matches");
        } else {
            System.out.println("It does not match");
        }
    }
}