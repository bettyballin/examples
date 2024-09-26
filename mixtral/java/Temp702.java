import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Temp702 {
    private static final Logger LOG = LogManager.getLogger(Temp702.class);

    public static void main(String[] args) {
        // Example usage
        byte[] sig = { (byte) 0x1F }; // example byte array
        String rs = byteToHex(sig[0]);
        if (rs.length() % 2 != 0) {
            // Add leading zero if the length is odd
            rs = "0" + rs;
        }
        LOG.debug("r:: " + rs);
    }

    private static String byteToHex(byte b) {
        return Integer.toHexString(b & 0xFF);
    }
}


In order to run this code, ensure you have the Log4j library in your classpath. You can include it using Maven:

xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.14.1</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.14.1</version>
</dependency>