import java.util.Arrays;

public class Temp1089 {
    public static void main(String[] args) {
        byte[] encryptData = {65, 66, 67, 68};
        byte[] decryptData = {72, 69, 76, 76, 79};

        System.out.println(Arrays.toString(encryptData));
        System.out.println(new String(decryptData));
    }
}