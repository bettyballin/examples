import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

// Assuming JsonConverterOfYourChoice is a placeholder for an actual JSON converter class
public class ConverterExample {
    
    public static void main(String[] args) {
        // Assuming JsonMapper is a properly instantiated ObjectMapper or similar
        HttpMessageConverter<?> converter = new MappingJackson2HttpMessageConverter(); // Replace with your JSON converter

        // This part of the code is not valid because getSupportedMediaTypes() returns an unmodifiable list
        // So instead, we need to extend the converter and set the supported media types in the constructor
        if (converter instanceof MappingJackson2HttpMessageConverter) {
            MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter) converter;
            jsonConverter.setSupportedMediaTypes(Arrays.asList(
                new MediaType("application", "json"),
                new MediaType("application", "csp-report") // Add custom media type
            ));
        }
        
        // Rest of your code that uses the converter
    }
}