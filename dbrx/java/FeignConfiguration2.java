import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import feign.codec.ErrorDecoder;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.Logger;
import feign.Feign;
import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;

@Configuration
public class FeignConfiguration implements FeignFormatterRegistrar {

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        // Register the JWT token formatter here
    }

    @Bean
    public Feign.Builder feignBuilder(Decoder decoder, Encoder encoder, ErrorDecoder errorDecoder, Logger logger, RequestInterceptor requestInterceptor) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(decoder)
                .encoder(encoder)
                .errorDecoder(errorDecoder)
                .logger(logger)
                .requestInterceptor(requestInterceptor);
    }
}