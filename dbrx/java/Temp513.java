public class Temp513 {
    public static void main(String[] args) {
        
        long[] sig = {12345L, 67890L}; // Sample values for demonstration
        
        String rHex = String.format("%016x", sig[0]);
        String sHex = String.format("%016x", sig[1]);
        
        // Combine R and S values into one string separated by ':'
        String signature = rHex + ":" + sHex;
        
        System.out.println(signature); // Print the signature to verify the result
    }
}