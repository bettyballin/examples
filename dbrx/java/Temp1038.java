import java.util.Arrays;

public class Temp1038 {
    public static void main(String[] args) {

        String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_$#-~";
        int maxLength = 10;

        for (int len = 1; len <= maxLength; len++) {
            int[] indices = new int[len];
            Arrays.fill(indices, 0);

            while (true) {
                StringBuilder potentialPW = new StringBuilder();
                for (int i : indices) {
                    potentialPW.append(SALTCHARS.charAt(i));
                }
                System.out.println(potentialPW.toString());

                // Increment the rightmost index
                int pos = len - 1;
                while (pos >= 0 && ++indices[pos] == SALTCHARS.length()) {
                    if (pos > 0) indices[pos--] = 0;
                    else break;
                }

                if (pos < 0 || (pos == 0 && indices[0] == SALTCHARS.length())) break;

            }
        }
    }
}