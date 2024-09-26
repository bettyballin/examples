import java.io.FileWriter;
import java.io.IOException;

public class Temp513 {
    public static void main(String[] args) {
        String[] entries = {"Entry1", "Entry2", "Entry3"}; // Example entries
        try (FileWriter writer = new FileWriter("manifest")) {
            for (String entry : entries) {
                writer.write(entry + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}