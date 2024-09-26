import javax.crypto.spec.IvParameterSpec;

public class Temp2585 {
    public static void main(String[] args) {
        byte[] iv = new byte[16];
        // Example initialization of iv
        for (int i = 0; i < iv.length; i++) {
            iv[i] = (byte) i;
        }
        
        IvParameterSpec spec = new IvParameterSpec(iv);
        
        // Example usage of spec (printing the IV to verify)
        byte[] ivBytes = spec.getIV();
        for (byte b : ivBytes) {
            System.out.print(b + " ");
        }
    }
}