import java.util.Random;

public class Temp2885 {
    public static void main(String[] args) {
        long seed = 20190921065347L; // identifies your current campaign
        int numCodes = 5; // you can set the number of codes you want to generate
        Random r = new Random(seed);
        for (int i = 0; i < numCodes; i++) {
            System.out.println(r.nextLong());
        }
    }
}