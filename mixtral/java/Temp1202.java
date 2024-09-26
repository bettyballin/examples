import java.io.*;

public class Temp1202 {
    public static void main(String[] args) {
        try {
            BufferedWriter bwr = new BufferedWriter(new FileWriter("C:\\Crpyto_Out.txt"));
            BufferedReader mbr = new BufferedReader(new FileReader("C:\\Crpyto_In.txt"));
            String line;
            while ((line = mbr.readLine()) != null) {
                String enSecretText = encrypt(line);
                bwr.write(enSecretText + "\n");
            }
            bwr.flush();
            bwr.close();
            mbr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String input) {
        // Placeholder for actual encryption logic
        return "encrypted_" + input;
    }
}