import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebSocketConfig {
    public void registerWebSocketInterceptors() {
        registration.interceptors().add(new ChannelInterceptorAdapter() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor =
                        MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

                if (accessor != null && StompCommand.CONNECT == accessor.getCommand()) {
                    // Extract the token from headers
                    String authToken = accessor.getFirstNativeHeader("authToken");

                    UsernamePasswordAuthenticationToken authentication;

                    try {
                        Profile profile = getProfileByAuthToken(authToken);

                        if (profile != null) {
                            List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));

                            authentication = new UsernamePasswordAuthenticationToken(profile, null, authorities);
                            accessor.setUser(authentication);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return message;
            }
        });
    }

    private Profile getProfileByAuthToken(String authToken) {
        // Implement this method to fetch the profile using the authToken
        return null;
    }

    private final Registration registration = new Registration();

    private static class Registration {
        public Interceptors interceptors() {
            return new Interceptors();
        }
    }

    private static class Interceptors {
        public void add(ChannelInterceptorAdapter interceptor) {
            // Implementation to add interceptor
        }
    }

    private static class Profile {
        // Profile class implementation
    }
}