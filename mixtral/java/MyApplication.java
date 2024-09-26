import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.security.spi.runtime.HttpAuthenticationMechanism;
import io.quarkus.deployment.Feature;

public class MyApplication implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        // your code here
        return 0;
    }

    static final String FEATURE = "my-custom-security";

    /**
     * The main method.
     */
    public static void main(final String[] args) {
        Quarkus.run(MyApplication.class, args);
    }

    @BuildStep
    Feature feature() {
        return Feature.builder(FEATURE).add(
            HttpAuthenticationMechanism.class,
            MyCustomHttpAuthMechanism.class
        ).build();
    }

    public static class MyCustomHttpAuthMechanism implements HttpAuthenticationMechanism {
        // Implement your custom authentication mechanism here
    }
}