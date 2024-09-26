import java.security.SecureRandom;

public class Temp2243 {
    public static void main(String[] args) {

        ThreadLocal<SecureRandom> secureRandom = new ThreadLocal<>() {
            @Override
            protected SecureRandom initialValue() {
                return new SecureRandom();
            }
        };

        // In each thread you can now safely call:
        System.out.println(secureRandom.get().nextInt());
    }
}