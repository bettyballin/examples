import java.util.Random;

public class Temp2886 {
    public static void main(String[] args) {
        long seed = 20190921065347L; // identifies your current campaign
        Random r = new Random(seed);
        int numCodes = 5; // Assuming numCodes since it was not defined in the original code
        r.longs(numCodes, 100_000_000_000_000L, 1_000_000_000_000_000L)
         .forEach(System.out::println);
    }
}