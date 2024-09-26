import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;

public class MyTestClass {

    private WebApplicationContext webAppContext;
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webAppContext);
        RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails();
        Authentication user = customAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken("admin", "123"));
        RestAssuredMockMvc.authentication(user);
        SecurityContextHolder.getContext().setAuthentication(user);
    }

    @Test
    public void makeSureLoginIsOk() {
        RestAssuredMockMvc.get("/myurl").then().statusCode(200);
    }
    
    // Assuming CustomAuthenticationProvider is defined elsewhere in the codebase
    private class CustomAuthenticationProvider {
        public Authentication authenticate(UsernamePasswordAuthenticationToken token) {
            // Authentication logic
            return token;
        }
    }
}