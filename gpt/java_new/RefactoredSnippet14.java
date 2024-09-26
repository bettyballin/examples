import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.core.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

public class RefactoredSnippet14 {

    public void refactorSnippet() {
        DefaultAuthorizationCodeTokenResponseClient tokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
        OAuth2AccessTokenResponseHttpMessageConverter tokenResponseHttpMessageConverter = new OAuth2AccessTokenResponseHttpMessageConverter();
        Converter<OAuth2AccessTokenResponse, String> accessTokenResponseConverter = tokenResponseHttpMessageConverter.getTokenResponseConverter();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(tokenResponseHttpMessageConverter);
        tokenResponseClient.setMessageConverters(messageConverters);
    }
}