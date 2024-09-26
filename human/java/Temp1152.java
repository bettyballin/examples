import org.mindrot.jbcrypt.BCrypt;

public class Temp1152 {
    public static void main(String[] args) {
        String plain_password = "yourPassword"; // Replace with the actual plain text password
        String salt = BCrypt.gensalt();
        String pw_hash = BCrypt.hashpw(plain_password, salt);

        System.out.println(salt);
        System.out.println(pw_hash);
    }
}