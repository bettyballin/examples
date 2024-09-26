import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Temp2095 {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);

        converter.getSupportedMediaTypes().add(new MediaType("application", "csp-report"));
    }
}