import java.io.FileInputStream;
import java.io.IOException;

public class FileReadExample {

    public static void main(String[] args) {
        String filePath = "path/to/your/local/file.txt";

        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}