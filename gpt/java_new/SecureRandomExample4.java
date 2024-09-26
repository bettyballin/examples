import java.security.SecureRandom;

public class SecureRandomExample4 {
    
    public static int nextSecureInt(int lowerBound, int upperBound) {
        SecureRandom random = new SecureRandom();
        int range = upperBound - lowerBound + 1;
        int secureRandomNumber = random.nextInt(range);
        return lowerBound + secureRandomNumber;
    }

    public static void main(String[] args) {
        int lowerBound = 0;
        int upperBound = 100;
        int secureRandomNumber = nextSecureInt(lowerBound, upperBound);
        
        System.out.println(secureRandomNumber);
    }
}