import java.util.zip.CRC32;
import java.util.zip.Checksum;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CRC32Collision {

    private static final char[] chars = "0123456789ABCDEF".toCharArray();

    public static String randomString() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Map<Long, String> map = new HashMap<>();
        Checksum checksum = new CRC32();
        while (true) {
            String text = randomString();
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            checksum.update(bytes, 0, bytes.length);
            long crcValue = checksum.getValue();
            if (map.containsKey(crcValue)) {
                System.out.println("Collision found:");
                System.out.println("Text 1: " + map.get(crcValue));
                System.out.println("Text 2: " + text);
                System.out.println("CRC32: " + crcValue);
                break;
            } else {
                map.put(crcValue, text);
            }
            checksum.reset();
        }
    }
}