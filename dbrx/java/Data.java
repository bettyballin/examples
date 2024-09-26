import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Data {
    private static final String file = "fileData.txt";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = br.read()) != -1) {
                // Clear the buffer after each character read
                if (sb.length() > 0 && !Character.isWhitespace(sb.charAt(0))) {
                    System.out.print("\b \b");
                    sb.deleteCharAt(0);
                }
                sb.append((char) c);
            }

            String data = sb.toString();
            // Clear the buffer after reading a line
            if (data.length() > 0 && !Character.isWhitespace(data.charAt(0))) {
                System.out.print("\b \b");
                if(sb.length() > 0) {
                    sb.deleteCharAt(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}