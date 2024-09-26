import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderExample3 {
    
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PasswordEncoderExample3.class);
    private static final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        String randomPassword = "admin";
        logger.info("Random Password: " + randomPassword);

        String encodedPassword = bCrypt.encode(randomPassword);
        logger.info("Encoded Random Password: " + encodedPassword);

        boolean b = bCrypt.matches(randomPassword, encodedPassword);
        System.out.println("This should be true (" + b + ")");
    }
}