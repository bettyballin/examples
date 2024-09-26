import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Main29 {
    public static void main(String[] args) {
        byte[] array = new byte[] { (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };
        String hex = new HexBinaryAdapter().marshal(array);
        System.out.println(hex);
    }
}