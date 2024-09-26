import javax.crypto.spec.IvParameterSpec;

public class Temp1109 {
    public static void main(String[] args) {
        // Example initialization vector (IV) bytes
        byte[] ivBytes = new byte[16]; // IV typically should be 16 bytes for AES
        IvParameterSpec ivParamSpec = new IvParameterSpec(ivBytes);
        
        // Print the IV to confirm
        System.out.println("IV: " + java.util.Arrays.toString(ivBytes));
    }
}