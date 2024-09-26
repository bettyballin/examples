import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    CSPHttpMessageConverter cspConverter = new CSPHttpMessageConverter();

    // Add your custom HttpMessageConverter to the list
    converters.add(cspConverter);

    // You can also add other message converter configurations here
  }
}

class CSPHttpMessageConverter implements HttpMessageConverter<Object> {
  // Implement required methods of HttpMessageConverter interface here

  @Override
  public boolean canRead(Class<?> clazz, org.springframework.http.MediaType mediaType) {
    // Implementation here
    return true;
  }

  @Override
  public boolean canWrite(Class<?> clazz, org.springframework.http.MediaType mediaType) {
    // Implementation here
    return true;
  }

  @Override
  public List<org.springframework.http.MediaType> getSupportedMediaTypes() {
    // Implementation here
    return List.of(org.springframework.http.MediaType.APPLICATION_JSON);
  }

  @Override
  public Object read(Class<?> clazz, org.springframework.http.HttpInputMessage inputMessage) {
    // Implementation here
    return null;
  }

  @Override
  public void write(Object o, org.springframework.http.MediaType contentType, org.springframework.http.HttpOutputMessage outputMessage) {
    // Implementation here
  }
}