import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class Temp2304 {

    private static final String URL_EXPERIENCES = "/experiences";
    private static final String CONTENT_TYPE = "application/json";

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    @Autowired
    private Authentication authentication;

    @Autowired
    private Object experience;

    @Autowired
    private String json;

    private MockMvc mockMvc;

    public static void main(String[] args) {
        Temp2304 temp2304 = new Temp2304();
        temp2304.setup();
        temp2304.runTest();
    }

    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilters(springSecurityFilterChain).build();
    }

    public void runTest() {
        try {
            mockMvc.perform(post(URL_EXPERIENCES).principal(authentication)
                    .content(json).contentType(CONTENT_TYPE))
                    .andExpect(status().isForbidden());
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e.getCause() instanceof AccessDeniedException);
        }
    }
}