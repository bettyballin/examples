import org.apache.cxf.interceptor.security.SimpleAuthorizingInterceptor;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomAuthenticationFilter extends SimpleAuthorizingInterceptor {

    @Override
    public void filter(ContainerRequestContext context) {
        String authHeader = context.getHeaderString("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Validate Bearer Token against OpenAM STS and set user's claims in the security context.
        }
    }

    public static void main(String[] args) {
        // Sample code to test the filter
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        ContainerRequestContext context = new MockContainerRequestContext("Bearer sample_token");
        filter.filter(context);
    }
}

class MockContainerRequestContext implements ContainerRequestContext {
    private String authorizationHeader;

    public MockContainerRequestContext(String authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
    }

    @Override
    public String getHeaderString(String name) {
        if ("Authorization".equals(name)) {
            return authorizationHeader;
        }
        return null;
    }

    // Implement other methods from ContainerRequestContext as needed.
    @Override
    public Object getProperty(String name) {
        return null;
    }

    @Override
    public Collection<String> getPropertyNames() {
        return null;
    }

    @Override
    public void setProperty(String name, Object object) {}

    @Override
    public void removeProperty(String name) {}

    @Override
    public UriInfo getUriInfo() {
        return null;
    }

    @Override
    public void setRequestUri(URI requestUri) throws IllegalStateException {}

    @Override
    public void setRequestUri(URI baseUri, URI requestUri) throws IllegalStateException {}

    @Override
    public Request getRequest() {
        return null;
    }

    @Override
    public String getMethod() {
        return null;
    }

    @Override
    public void setMethod(String method) {}

    @Override
    public MultivaluedMap<String, String> getHeaders() {
        return null;
    }

    @Override
    public String getHeaderString(String name) {
        return null;
    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public Locale getLanguage() {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public MediaType getMediaType() {
        return null;
    }

    @Override
    public List<MediaType> getAcceptableMediaTypes() {
        return null;
    }

    @Override
    public List<Locale> getAcceptableLanguages() {
        return null;
    }

    @Override
    public Map<String, Cookie> getCookies() {
        return null;
    }

    @Override
    public boolean hasEntity() {
        return false;
    }

    @Override
    public InputStream getEntityStream() {
        return null;
    }

    @Override
    public void setEntityStream(InputStream input) {}

    @Override
    public SecurityContext getSecurityContext() {
        return null;
    }

    @Override
    public void setSecurityContext(SecurityContext context) {}

    @Override
    public void abortWith(Response response) {}
}