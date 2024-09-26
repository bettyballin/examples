import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.mockito.Mockito.mock;

public class ExperienceTest {

    private MockMvc mockMvc;
    private Authentication authentication;

    public ExperienceTest() {
        mockMvc = standaloneSetup(new ExperienceController()).build();
        authentication = mock(Authentication.class);
    }

    @Test
    public void postExperience() throws Exception {
        ExperienceEntity experience = new ExperienceEntity();
        experience.setExperience("Test");
        experience.setExperienceEng("Test");

        String URL_EXPERIENCES = "/experiences";

        mockMvc.perform(post(URL_EXPERIENCES)
                .principal(authentication)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(experience)))
                .andExpect(status().isOk());
    }
}