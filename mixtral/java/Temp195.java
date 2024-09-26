import java.io.*;
import java.nio.file.*;

public class Temp195 {
    public static void main(String[] args) {
        // Sample usage of writeFile and readFile methods
        Temp195 temp = new Temp195();
        String fileName = "example.txt";
        byte[] dataToWrite = "Hello, World!".getBytes();
        
        try {
            temp.writeFile(dataToWrite, fileName);
            byte[] dataRead = temp.readFile(fileName);
            System.out.println(new String(dataRead));
        } catch (IOException | Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(byte[] data, String fileName) throws IOException {
        try (OutputStream out = new FileOutputStream(fileName)) {
            out.write(data);
        }
    }

    public byte[] readFile(String filename) throws Exception {
        Path path = Paths.get(filename);
        return Files.readAllBytes(path);
    }
}