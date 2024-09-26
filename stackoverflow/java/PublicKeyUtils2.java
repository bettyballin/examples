public class PublicKeyUtils2 {

    private static final String BEGIN = "-----BEGIN PUBLIC KEY-----";
    private static final String END = "-----END PUBLIC KEY-----";

    public static String toBase64DER(String pem) {
        return pem.replace("
", "") //remove all line breaks 

                .replace(BEGIN, "") // remove beginning of PEM
                .replace(END, ""); //remove ending of PEM
    }

    public static void main(String[] args) {
        String pemKey = BEGIN + "
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvfLHfLIfTrCk
" + END;
        System.out.println(toBase64DER(pemKey));
    }
}