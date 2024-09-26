import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

public class Temp1347 {
    public static void main(String[] args) {
        Temp1347 temp = new Temp1347();
        String source = "exampleString";
        System.out.println(temp.reverseMethod(source));
    }

    private byte[] getBytes(String str) {
        String[] parts = str.split("(?<=\\G...)");

        ByteBuffer bb = ByteBuffer.allocate(parts.length);

        Arrays.stream(parts).forEach((part) -> {
            int i = Integer.parseInt(part, 10) & 0xFF;

            byte value = (byte) (i < 0 ? i + 256 : i);

            bb.put(value);
        });

        return bb.array();
    }

    public String reverseMethod(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] bytes = getBytes(source);

            StringBuilder sb = new StringBuilder();

            for (byte b : bytes)
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1));

            return sb.toString().toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}