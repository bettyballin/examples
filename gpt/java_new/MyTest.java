import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.mock.web.MockMultipartFile;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;

public class MyTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("myAttributeManagerUsername")
    public void attributes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/resources/1/attributes")
                .file(attributesFile()))
                .andExpect(status().isOk());
    }

    private MockMultipartFile attributesFile() {
        // Dummy file creation for example purposes
        return new MockMultipartFile("file", "test.txt", "text/plain", "Some content".getBytes());
    }
}