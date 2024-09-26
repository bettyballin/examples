import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.security.config.annotation.rsocket.AbstractRSocketSecurity;
import org.springframework.security.config.annotation.rsocket.EnableRSocketSecurity;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
import org.springframework.security.rsocket.core.PayloadSocketAcceptorInterceptor;
import org.springframework.security.rsocket.metadata.SimpleAuthenticationEncoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadata;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataBearer;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataBearerAuthentication;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataEncoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataCredentials;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataCredentials.Authentication;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.SimpleAuthentication;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.SimpleAuthenticationDecoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.SimpleAuthenticationEncoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.SimpleAuthenticationMetadata;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.SimpleAuthenticationMetadataDecoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.SimpleAuthenticationMetadataEncoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.UsernamePasswordMetadataDecoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.UsernamePasswordMetadataEncoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.UsernamePasswordMetadataEncoderMetadata;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.UsernamePasswordMetadataEncoderMetadataDecoder;
import org.springframework.security.rsocket.metadata.UsernamePasswordMetadataDecoder.UsernamePasswordMetadataEncoderMetadataEncoder;

import java.util.Collections;
import java.util.List;

import reactor.core.publisher.Mono;

@Configuration
@EnableRSocketSecurity
public class RSocketSecurityConfig extends AbstractRSocketSecurity {

    @Override
    protected void configure(RSocketSecurity rsocket) {
        rsocket
            .authorizePayload(authorize -> authorize
                .anyRequest().authenticated()
                .anyExchange().permitAll()
            )
            .simpleAuthentication(Customizer.withDefaults());
    }

    @Override
    protected List<PayloadSocketAcceptorInterceptor> getAdditionalExtensions() {
        return Collections.singletonList((request, next) -> Mono.justOrEmpty(new UsernamePasswordMetadata("user", "password")));
    }

    @Bean
    public RSocketStrategies rSocketStrategies() {
        return RSocketStrategies.builder()
            .encoder(new SimpleAuthenticationEncoder())
            .decoder(new SimpleAuthenticationDecoder())
            .build();
    }
}