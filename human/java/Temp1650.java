import java.util.Arrays;

public class Temp1650 {
    public static void main(String[] args) {
        byte[] digest1 = {1, 2, 3, 4};
        byte[] digest2 = {1, 2, 3, 4};

        if (Arrays.equals(digest1, digest2))
            System.out.println(true);
        else
            System.out.println(false);
    }
}