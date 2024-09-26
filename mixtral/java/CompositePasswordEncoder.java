import java.util.List;
import java.util.stream.Stream;

interface PasswordEncoder {
    String encode(CharSequence rawPassword);
    boolean matches(CharSequence rawPassword, String encodedPassword);
}

public class CompositePasswordEncoder implements PasswordEncoder {
    private List<PasswordEncoder> passwordEncoders;

    public void setPasswordEncoders(List<PasswordEncoder> passwordEncoders) {
        this.passwordEncoders = passwordEncoders;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        throw new UnsupportedOperationException("This encoder is for decoding only");
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoders.stream()
                .anyMatch(encoder -> encoder.matches(rawPassword, encodedPassword));
    }

    public static void main(String[] args) {
        // Example usage (Note: In a real scenario, proper PasswordEncoder implementations should be used)
        PasswordEncoder encoder1 = new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString() + "1";
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(rawPassword.toString() + "1");
            }
        };

        PasswordEncoder encoder2 = new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString() + "2";
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(rawPassword.toString() + "2");
            }
        };

        CompositePasswordEncoder compositeEncoder = new CompositePasswordEncoder();
        compositeEncoder.setPasswordEncoders(List.of(encoder1, encoder2));

        System.out.println(compositeEncoder.matches("password", "password1")); // true
        System.out.println(compositeEncoder.matches("password", "password2")); // true
        System.out.println(compositeEncoder.matches("password", "password3")); // false
    }
}