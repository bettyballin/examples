import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.format.Formatter;
import java.util.Locale;
import java.text.ParseException;

@Configuration
public class FeignConfiguration implements FeignFormatterRegistrar {

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addFormatter(new JwtTokenFormatter());
    }
}

class JwtTokenFormatter implements Formatter<String> {

    @Override
    public String print(String object, Locale locale) {
        return object; // Implement your formatting logic here
    }

    @Override
    public String parse(String text, Locale locale) throws ParseException {
        return text; // Implement your parsing logic here
    }
}