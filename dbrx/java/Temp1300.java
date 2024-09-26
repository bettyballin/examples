public class Temp1300 {
    public static void main(String[] args) {
        String publicKey = "yourPublicKeyHere";
        String publicKeyWithoutNewlines = publicKey.replace("\n", "");
        System.out.println(publicKeyWithoutNewlines);
    }
}