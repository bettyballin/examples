public class Temp3283 {
    public static void main(String[] args) {
        System.setProperty("jdk.tls.ephemeralDHKeySize", "1024");
        System.setProperty("jdk.certpath.disabledAlgorithms", "MD2, MD5, DSA, RSA keySize < 2048");
        System.setProperty("jdk.tls.disabledAlgorithms", "DH keySize < 1024, SSLv2, SSLv3, TLSv1, TLSv1.1, DHE_DSS, RSA_EXPORT, DHE_DSS_EXPORT, DHE_RSA_EXPORT, DH_DSS_EXPORT, DH_RSA_EXPORT, DH_anon, ECDH_anon, DH_RSA, DH_DSS, ECDH, 3DES_EDE_CBC, DES_CBC, RC4_40, RC4_128, DES40_CBC, RC2, HmacMD5");
        System.setProperty("jdk.tls.legacyAlgorithms", "");
        
        System.out.println("System properties set successfully.");
    }
}