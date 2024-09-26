import java.security.SecureRandom;

public class Temp3292 {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(secureRandom.ints().distinct().iterator().next()));
        Thread t2 = new Thread(() -> System.out.println(secureRandom.ints().distinct().iterator().next()));
        t1.start();
        t2.start();
    }
}