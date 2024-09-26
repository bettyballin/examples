public class Temp1450 {
    public static void main(String[] args) {
        String[] tlsSuites = {
            "TLS_DHE_RSA_WITH_AES_128_CBC_SHA",
            "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
            "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256"
        };

        for (String suite : tlsSuites) {
            System.out.println(suite);
        }
    }
}