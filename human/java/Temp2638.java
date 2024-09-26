import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2638 {
    public static void main(String[] args) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String str = b.encode("admin@123");
        System.out.println("Encoding " + str);
    }
}