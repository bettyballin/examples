import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.TextDocumentManager;
import com.marklogic.client.io.StringHandle;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MarkLogicAuthProvider implements AuthenticationProvider {

    private final DatabaseClientFactory databaseClientFactory;
    private final String host;
    private final int port;
    private final String database;

    public MarkLogicAuthProvider(DatabaseClientFactory databaseClientFactory, String host, int port, String database) {
        this.databaseClientFactory = databaseClientFactory;
        this.host = host;
        this.port = port;
        this.database = database;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(Authentication.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        DatabaseClient client = null;
        try {
            client = databaseClientFactory.newClient(host, port, database, new DatabaseClientFactory.DigestAuthContext(username, password));
            
            // Verify if we can retrieve some data to ensure the credentials are correct
            TextDocumentManager docMgr = client.newTextDocumentManager();
            String docId = "/example/document.txt";
            StringHandle handle = new StringHandle();
            docMgr.read(docId, handle);

            // If no exception is thrown, authentication is successful
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new UserAuthentication(username, authorities);

        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username or password");
        } finally {
            if (client != null) {
                client.release();
            }
        }
    }

    public static class UserAuthentication implements Authentication {
        private final String username;
        private final List<GrantedAuthority> authorities;
        private boolean authenticated = true;

        public UserAuthentication(String username, List<GrantedAuthority> authorities) {
            this.username = username;
            this.authorities = authorities;
        }

        @Override
        public String getName() {
            return username;
        }

        @Override
        public List<GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public Object getCredentials() {
            return null;
        }

        @Override
        public Object getDetails() {
            return null;
        }

        @Override
        public Object getPrincipal() {
            return username;
        }

        @Override
        public boolean isAuthenticated() {
            return authenticated;
        }

        @Override
        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            this.authenticated = isAuthenticated;
        }
    }

    public static void main(String[] args) {
        // Example usage
        DatabaseClientFactory factory = DatabaseClientFactory.newClient();
        MarkLogicAuthProvider provider = new MarkLogicAuthProvider(factory, "localhost", 8000, "mydatabase");
        // Use the provider to authenticate
    }
}