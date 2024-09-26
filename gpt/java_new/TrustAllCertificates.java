import javax.net.ssl.*;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.io.*;
import java.security.SecureRandom;

public class TrustAllCertificates {

    public static void main(String[] args) {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = (hostname, session) -> true;
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            // Now you can access an https URL without having the certificate in the truststore
            URL url = new URL("https://example.com");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            // Read the response
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                System.out.println(input);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}