import javax.net.ssl.X509TrustManager;

public class YouNameClass implements X509TrustManager {

   public YouNameClass() {
      super();
   }

   @Override
   public void checkClientTrusted(X509Certificate[] chain, String authType) {
   }

   @Override
   public void checkServerTrusted(X509Certificate[] chain, String authType) {
   }

   @Override
   public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[0];
   }
}