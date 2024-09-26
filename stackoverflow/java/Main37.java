import java.math.BigInteger;

public class Main37 {
    public static void main(String[] args) {
        String pHex = "fca682ce8e12caba26efccf7110e526db078b05edecbcd1eb4a208f3" +
                      "ae1617ae01f35b91a47e6df63413c5e12ed0899bcd132acd50d99151" +
                      "bdc43ee737592e17";
        String gHex = "678471b27a9cf44ee91a49c5147db1a9aaf244f05a434d6486931d2d" +
                      "14271b9e35030b71fd73da179069b32e2935630e1c2062354d0da20a" +
                      "6c416e50be794ca4";

        BigInteger p = new BigInteger(pHex, 16);
        BigInteger g = new BigInteger(gHex, 16);
        
        // Use p and g for whatever purpose they are intended for
    }
}