import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
@Component
public class OAuthTokenInterceptor implements ClientHttpRequestInterceptor {
  private final TokenService tokenService;

  @NotNull
  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                      ClientHttpRequestExecution execution) throws IOException {
    request.getHeaders().add("Authorization", "Bearer " + tokenService.getRefreshedToken().getValue());
    return execution.execute(request, body);
  }
}