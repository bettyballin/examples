import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;

public class Main {

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

        String s3 = new String(toByteArray(s2));
        System.out.println(s3);

        String s4 = toHexString(s1, "ISO-8859-15");
        System.out.println(s4);

        String s5 = new String(toByteArray(s4));
        System.out.println(s5);
    }
}