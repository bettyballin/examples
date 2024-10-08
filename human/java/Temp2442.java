public class Temp2442 {
    public static void main(String[] args) {
        String[] ciphers = {
            "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA",
            "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA",
            "SSL_DHE_DSS_WITH_DES_CBC_SHA",
            "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA",
            "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA",
            "SSL_DHE_RSA_WITH_DES_CBC_SHA",
            "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA",
            "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA",
            "SSL_DH_anon_WITH_DES_CBC_SHA",
            "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA",
            "SSL_RSA_WITH_3DES_EDE_CBC_SHA",
            "SSL_RSA_WITH_DES_CBC_SHA",
            "SSL_RSA_WITH_NULL_MD5",
            "SSL_RSA_WITH_NULL_SHA",
            "TLS_DHE_DSS_WITH_AES_128_CBC_SHA",
            "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256",
            "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256",
            "TLS_DHE_RSA_WITH_AES_128_CBC_SHA",
            "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
            "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
            "TLS_DH_anon_WITH_AES_128_CBC_SHA",
            "TLS_DH_anon_WITH_AES_128_CBC_SHA256",
            "TLS_DH_anon_WITH_AES_128_GCM_SHA256",
            "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA",
            "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
            "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
            "TLS_ECDHE_ECDSA_WITH_NULL_SHA",
            "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA",
            "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
            "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
            "TLS_ECDHE_RSA_WITH_NULL_SHA",
            "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA",
            "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256",
            "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256",
            "TLS_ECDH_ECDSA_WITH_NULL_SHA",
            "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA",
            "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256",
            "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256",
            "TLS_ECDH_RSA_WITH_NULL_SHA",
            "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA",
            "TLS_ECDH_anon_WITH_AES_128_CBC_SHA",
            "TLS_ECDH_anon_WITH_NULL_SHA",
            "TLS_EMPTY_RENEGOTIATION_INFO_SCSV",
            "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5",
            "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA",
            "TLS_KRB5_WITH_3DES_EDE_CBC_MD5",
            "TLS_KRB5_WITH_3DES_EDE_CBC_SHA",
            "TLS_KRB5_WITH_DES_CBC_MD5",
            "TLS_KRB5_WITH_DES_CBC_SHA",
            "TLS_RSA_WITH_AES_128_CBC_SHA",
            "TLS_RSA_WITH_AES_128_CBC_SHA256",
            "TLS_RSA_WITH_AES_128_GCM_SHA256",
            "TLS_RSA_WITH_NULL_SHA256"
        };

        System.out.println("Default Cipher");
        for (String cipher : ciphers) {
            if (cipher.contains("3DES") || cipher.contains("AES") || cipher.contains("RENEGOTIATION")) {
                System.out.print("   *    ");
            } else {
                System.out.print("        ");
            }
            System.out.println(cipher);
        }
    }
}