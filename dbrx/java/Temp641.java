import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.IOException;
import java.util.Base64;

public class Temp641 {
    public static void main(String[] args) {
        char[] base64CharArray = "U29tZSBleGFtcGxlIGJhc2U2NCBlbmNvZGVkIHN0cmluZw==".toCharArray(); // Example Base64 string
        byte[] decodedBytes;

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            try (Writer writer = new OutputStreamWriter(outputStream)) {
                for (char c : base64CharArray) {
                    if (!Character.isWhitespace(c)) { // Ignore whitespace characters.
                        writer.write(c);
                    }
                }

                writer.flush(); // Ensure all data is written to the outputStream
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] encodedBytes = outputStream.toByteArray();
            decodedBytes = Base64.getDecoder().decode(encodedBytes);
            
            // Print the decoded string for verification
            System.out.println(new String(decodedBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}