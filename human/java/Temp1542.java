import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.RequestPostProcessor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class Temp1542 {

    public static void main(String[] args) throws Exception {
        MockMvc mockMvc = standaloneSetup(new Temp1542()).build();
        Object principal = new Object(); // Placeholder for a real principal object

        mockMvc.perform(post("/owner/terminals/edit").principal(principal).with(new RequestPostProcessor() {
            public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
                request.addUserRole("ROLE_OWNER");
                return request;
            }
        }));
    }
}