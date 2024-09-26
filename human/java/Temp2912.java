public class Temp2912 {
    private static final String BEGIN = "-----BEGIN PUBLIC KEY-----";
    private static final String END = "-----END PUBLIC KEY-----";

    public static String toBase64DER(String pem) {
        return pem.replace("\n", "") //remove all line breaks \n
                .replace(BEGIN, "") // remove beginning of PEM
                .replace(END, ""); //remove ending of PEM
    }

    public static void main(String[] args) {
        String pem = "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4G8jUDY\n-----END PUBLIC KEY-----";
        System.out.println(toBase64DER(pem));
    }
}