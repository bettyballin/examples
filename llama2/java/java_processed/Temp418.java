import java.nio.ByteBuffer;
import java.util.Random;

public class Temp418 {
    public static void main(String[] args) {
        // Generate a random seed
        Random rand = new Random();
        byte[] seed = new byte[4];
        rand.nextBytes(seed);
        
        // Wrap the seed into a ByteBuffer
        ByteBuffer buffer = ByteBuffer.wrap(seed);
        
        // Get an integer from the ByteBuffer
        int randomInt = buffer.getInt();
        
        // Print the random integer
        System.out.println("Random integer: " + randomInt);
    }
}