import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class NonRepeatedPRNG {
    private final Random rnd = new Random();
    private final Set<Integer> set = new HashSet<>();

    public int nextInt() {
        for (;;) {
            final int r = rnd.nextInt();
            if (set.add(r)) return r;
        }
    }

    public static void main(String[] args) {
        NonRepeatedPRNG prng = new NonRepeatedPRNG();
        for (int i = 0; i < 10; i++) {
            System.out.println(prng.nextInt());
        }
    }
}