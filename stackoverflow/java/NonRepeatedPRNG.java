import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NonRepeatedPRNG {
  private final Random rnd = new Random();
  private final Set<Integer> set = new HashSet<>();

  public int nextInt() {
    int r;
    do {
      r = rnd.nextInt();
    } while (!set.add(r));
    return r;
  }
}