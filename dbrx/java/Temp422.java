import org.apache.commons.math3.random.RandomDataGenerator;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        RandomDataGenerator rnd = new RandomDataGenerator();
        int upperBound = 10; // Define the upper bound
        System.out.println(rnd.nextInt(0, upperBound - 1)); 
    }
}