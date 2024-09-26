public class Temp1772 {
    public static void main(String[] args) {
        System.setProperty("jdk.tls.disabledAlgorithms", "MD5, SHA1, DSA, RSA keySize < 4096");
        String disabledAlgorithms = System.getProperty("jdk.tls.disabledAlgorithms");
        System.out.println("Disabled Algorithms: " + disabledAlgorithms);
    }
}