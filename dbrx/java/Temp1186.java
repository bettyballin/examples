import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMultipartFile;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithUserDetails;

@SpringBootTest
@AutoConfigureMockMvc
public class Temp1186 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("myAttributeManagerUsername")
    public void attributes() throws Exception {
        // Get authentication from SecurityContextHolder
        Authentication authentication = 
            SecurityContextHolder.getContext().getAuthentication();

        // No need to set the security context explicitly in your test method
        // @WithUserDetails annotation already does it

        mockMvc.perform(
                MockMvcRequestBuilders.multipart("/api/resources/1/attributes")
                    .file(attributesFile())
            )
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private MockMultipartFile attributesFile() {
        return new MockMultipartFile("file", "attributes.txt", "text/plain", "some attributes".getBytes());
    }
}