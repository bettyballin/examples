import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

public class Temp2168 {

    @Autowired
    private WebApplicationContext webAppContext;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webAppContext, springSecurity());
        RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails();
        Authentication user = customAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken("admin", "123"));
        RestAssuredMockMvc.authentication(user);
        SecurityContextHolder.getContext().setAuthentication(user);
    }

    @Test
    public void makeSureLoginIsOk() {
        RestAssuredMockMvc.get("/myurl").then().statusCode(200);
    }
}