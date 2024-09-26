import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Temp853 {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String md5Salt = "yourMd5SaltHere";  // Replace with your actual salt
        PasswordEncoder passwordEncoder = new MessageDigestPasswordEncoder("MD5");
        if (md5Salt != null && !md5Salt.isEmpty()) {
            System.out.println("Setting salt: " + md5Salt);
        }
        auth
           .inMemoryAuthentication()
           .withUser("user").password(passwordEncoder.encode("password")).roles("USER");
    }

    public static void main(String[] args) {
        // Spring Boot application would start here
    }
}