import java.util.Arrays;

public class Temp1928 {
    public static void main(String[] args) {
        byte[] xBytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};
        byte[] yBytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};

        if(xBytes[0] == 0 && xBytes.length > 31){
            xBytes = Arrays.copyOfRange(xBytes, 1, xBytes.length);
        }

        if(yBytes[0] == 0 && yBytes.length > 31){
            yBytes = Arrays.copyOfRange(yBytes, 1, yBytes.length);
        }

        System.out.println("xBytes: " + Arrays.toString(xBytes));
        System.out.println("yBytes: " + Arrays.toString(yBytes));
    }
}