import java.util.List;
import java.util.ArrayList;

public class CyclicGroupGenerator {

    private int order; 

    public CyclicGroupGenerator(int order) {
        this.order = order;
    }

    private List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public int getGenerator() {
        List<Integer> factors = getFactors(order - 1);
        for (int candidate = 2; candidate < order; candidate++) {
            boolean isGenerator = true;
            for (int factor : factors) {
                if (Math.pow(candidate, (order - 1) / factor) % order == 1) {
                    isGenerator = false;
                    break;
                }
            }
            if (isGenerator) {
                return candidate;
            }
        }
        return -1; // No generator found
    }

    public static void main(String[] args) {
        CyclicGroupGenerator generator = new CyclicGroupGenerator(17);
        System.out.println("Generator: " + generator.getGenerator());
    }
}