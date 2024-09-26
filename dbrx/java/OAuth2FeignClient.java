import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class OAuth2FeignClient extends Feign.Builder {
    private final String accessToken;

    public OAuth2FeignClient(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public <T> T target(Class<T> apiType, String url) {
        return super.target(apiType, url).requestInterceptor(new OAuth2RequestInterceptor(accessToken));
    }

    private class OAuth2RequestInterceptor implements RequestInterceptor {
        private final String accessToken;

        public OAuth2RequestInterceptor(String accessToken) {
            this.accessToken = accessToken;
        }

        @Override
        public void apply(RequestTemplate template) {
            if (accessToken != null && !template.headers().containsKey("Authorization")) {
                template.header("Authorization", "Bearer " + accessToken);
            }
        }
    }

    public static void main(String[] args) {
        OAuth2FeignClient client = new OAuth2FeignClient("your_access_token_here");
        // Example usage:
        // MyApi api = client.target(MyApi.class, "https://api.example.com");
    }
}