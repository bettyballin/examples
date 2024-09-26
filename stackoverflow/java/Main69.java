import java.math.BigInteger;
import javax.xml.bind.DatatypeConverter;

public class Main69 {

    public static String toHexString(String arg, String encoding) throws Exception {
        return String.format("%040x", new BigInteger(1, arg.getBytes(encoding)));
    }

    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }

    public static void main(String[] args) throws Exception {
        String s1 = "Ž81‡Ç¬ú²±DN¢HÜ4ºÜºT÷.Ê+ŠÀ";
        System.out.println(s1);

        String s2 = toHexString(s1, "UTF-8");
        System.out.println(s2);

        byte[] s3bytes = toByteArray(s2);
        String s3 = new String(s3bytes, "UTF-8");
        System.out.println(s3);

        String s4 = toHexString(s1, "ISO-8859-15");
        System.out.println(s4);

        byte[] s5bytes = toByteArray(s4);
        String s5 = new String(s5bytes, "ISO-8859-15");
        System.out.println(s5);
    }
}