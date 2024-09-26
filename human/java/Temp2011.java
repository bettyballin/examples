import java.nio.charset.StandardCharsets;

public class Temp2011 {
    public static void main(String[] args) {
        byte[] byteArray = "ECE7D4111337A511F81CBF2E3E42D105".getBytes(StandardCharsets.UTF_8);
        for (byte b : byteArray) {
            System.out.printf("%02X ", b);
        }
    }
}