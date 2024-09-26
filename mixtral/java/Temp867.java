import java.util.Arrays;

public class Temp867 {
    public static void main(String[] args) {
        byte[] key = new byte[20];
        Arrays.fill(key, (byte) 14); // ASCII value of 'dd' is 14

        byte[] data = "84c1eefa3fcdcccecfdf2edaeebb679debaeaacbfecafad".getBytes();

        // Just printing out the values to show the code works
        System.out.println(Arrays.toString(key));
        System.out.println(Arrays.toString(data));
    }
}