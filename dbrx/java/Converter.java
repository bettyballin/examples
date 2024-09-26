import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Converter {
    private static String readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (stringBuilder.length() > 0)
                    stringBuilder.append("\n");
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        try {
            String content = readFile("example.txt");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}