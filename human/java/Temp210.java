import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Temp210 {
    public static void main(String[] args) {
        try {
            // Create a Cipher object
            Cipher cipher = Cipher.getInstance("AES");

            // Assume you have your input and output files
            File inputFile = new File("inputFile.txt");
            File outputFile = new File("outputFile.txt");

            // Create input and output streams
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);

            // Read the input file into a byte array
            byte[] byteBuffer = new byte[(int) inputFile.length()];
            DataInputStream dis = new DataInputStream(inputStream);
            dis.readFully(byteBuffer);
            dis.close();

            // Write the byte array to the output file using CipherOutputStream
            CipherOutputStream cos = new CipherOutputStream(outputStream, cipher);
            cos.write(byteBuffer);
            cos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}