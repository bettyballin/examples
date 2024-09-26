import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Temp2044 {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        try (BufferedReader mbr = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bwr = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = mbr.readLine()) != null) {
                String enSecretText = encrypt(line);
                bwr.write(enSecretText);
                bwr.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String text) {
        // Dummy encryption logic for demonstration
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            encrypted.append((char) (c + 1));
        }
        return encrypted.toString();
    }
}