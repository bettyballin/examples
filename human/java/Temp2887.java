import java.util.Random;

public class Temp2887 {
    public static void main(String[] args) {
        long seed = 20190921065347L; // identifies your current campaign
        Random r = new Random(seed);
        long numCodes = 10; // Specify the number of codes to generate, replace 10 with your desired number
        System.out.println(
            r.longs(numCodes, 100_000_000_000_000L, 1_000_000_000_000_000L)
             .anyMatch(l -> l == 350160558695557L));
    }
}