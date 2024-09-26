import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main15 {
    public static void main(String[] args) {
        String salt = "this is a simple clear salt";
        StringBuilder textBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("original.txt", StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileContent = textBuilder.toString();
        System.out.println(fileContent + salt);
    }
}