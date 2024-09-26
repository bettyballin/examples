import java.security.SecureRandom;

public class RandomStringGenerator {
    
    public String createRandomCode(int codeLength) {
        String id = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars = id.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        
        for (int i = 0; i < codeLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        RandomStringGenerator generator = new RandomStringGenerator();
        String randomCode = generator.createRandomCode(10);
        System.out.println(randomCode);
    }
}