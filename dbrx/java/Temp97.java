import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

public class Temp97 {
    public static void main(String[] args) {
        // Example using OkHttp library:
        CertificatePinner certificatePinner = new CertificatePinner.Builder()
            .add("publicobject.com", "sha256/AAAAAAAAAAAAAAAAAAAAAAAAAAA=")
            .build();

        OkHttpClient client = new OkHttpClient.Builder()
            .certificatePinner(certificatePinner)
            .build();
        
        System.out.println("OkHttpClient created with CertificatePinner.");
    }
}