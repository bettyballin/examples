import java.security.SecureRandom;

public class Temp616 {
    public static void main(String[] args) {
        System.out.println(getRandomString(64)); // Example usage
    }

    public static String getRandomString(int bitSize) {
        int charCount = bitSize / 4; // Each alphanumeric character is represented by a nibble or half-byte.
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(charCount);
        
        for (int i = 0; i < charCount; i++) {
            int randomNumber = random.nextInt(36); // Alphanumeric characters are in the range of [10-35] and digits from '0' to '9'.
            
            if (randomNumber >= 26) { // If it's a letter convert it back into its ASCII representation.
                sb.append((char)(randomNumber + 55));
            } else {
                sb.append((char)(randomNumber + 48)); // Otherwise append the digit as is.
            }
        }

        return sb.toString();
    }
}