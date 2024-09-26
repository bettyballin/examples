import org.apache.commons.codec.digest.DigestUtils;

public class HashExample1 {
    public static void main(String[] args) {
        String id = "exampleId";
        
        // Using DigestUtils.md5Hex() to generate a hex string
        String md5Hex = DigestUtils.md5Hex(id);
        System.out.println(md5Hex);
        
        // Using DigestUtils.md5() to generate a byte array
        byte[] md5Bytes = DigestUtils.md5(id);
        for (byte b : md5Bytes) {
            System.out.format("%02x", b);
        }
    }
}