import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;

public class Temp3536 {
    public static void main(String[] args) {
        byte[] d = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        byte[] e = new byte[]{8, 7, 6, 5, 4, 3, 2, 1};
        IvParameterSpec param = new IvParameterSpec(d);

        // Printing the IV to verify
        System.out.println("IV: " + java.util.Arrays.toString(param.getIV()));
    }
}