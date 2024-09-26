import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.util.List;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class Temp2519 {

    private SecurityService securityService = new SecurityService();
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @WithMockUser
    void shouldGetUserDataGivenUserId() throws Exception {

        // Set up your test data and behavior
        TestService testService = new TestService();
        TestController testController = new TestController(testService);

        mockMvc = standaloneSetup(testController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .apply(springSecurity())
                .build();

        // Perform your test
        // mockMvc.perform(...);
    }

    // Dummy classes to make the code compile
    static class SecurityService {
    }

    static class TestService {
    }

    static class TestController {
        private final TestService testService;

        public TestController(TestService testService) {
            this.testService = testService;
        }
    }

    static class PageableHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return false;
        }

        @Override
        public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
            return null;
        }
    }
}