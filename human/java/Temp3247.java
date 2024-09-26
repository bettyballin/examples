import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import software.amazon.awssdk.http.HttpExecuteRequest;
import software.amazon.awssdk.http.HttpExecuteResponse;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.SdkHttpFullRequest;
import software.amazon.awssdk.http.SdkHttpMethod;
import software.amazon.awssdk.http.apache.ApacheHttpClient;

public class Temp3247 {
    public static void main(String[] args) throws Exception {
        Path clientKeyStore = Paths.get("path/to/client/keystore.p12");
        System.setProperty("javax.net.ssl.keyStore", clientKeyStore.toAbsolutePath().toString());
        System.setProperty("javax.net.ssl.keyStoreType", "pkcs12");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        Path serverKeyStore = Paths.get("path/to/server/keystore.jks");
        System.setProperty("javax.net.ssl.trustStore", serverKeyStore.toAbsolutePath().toString());
        System.setProperty("javax.net.ssl.trustStorePassword", "password");
        System.setProperty("javax.net.ssl.trustStoreType", "jks");

        SdkHttpClient client = ApacheHttpClient.builder().build();

        SdkHttpFullRequest httpRequest = SdkHttpFullRequest.builder()
                .method(SdkHttpMethod.GET)
                .uri(new URI("https://<prefix>.credentials.iot.us-west-2.amazonaws.com/role-aliases/MyAlias/credentials"))
                .putHeader("x-amzn-iot-thingname", "myThingName")
                .build();

        HttpExecuteRequest request = HttpExecuteRequest.builder()
                .request(httpRequest)
                .build();

        HttpExecuteResponse response = client.prepareRequest(request).call();
        
        System.out.println("Response: " + response.httpResponse().statusCode());
    }
}