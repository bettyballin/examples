import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Temp1501 {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        Temp1501 temp = new Temp1501();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        temp.setBCryptPasswordEncoder(encoder);

        // Rest of code
        String rawPassword = "password123";
        String encodedPassword = temp.bCryptPasswordEncoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
    }

    public void setBCryptPasswordEncoder(BCryptPasswordEncoder b) {
        this.bCryptPasswordEncoder = b;
    }
}