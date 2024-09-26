import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = PDPController.class)
@AutoConfigureMockMvc(addFilters = true)
public class PDPControllerTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private MyUserDetailsService userDetailsService;

  @MockBean
  private JwtService jwtService;

  @Test
  @WithMockUser
  public void test() throws Exception {
    mvc.perform(
            get("/pdps/authentication").secure(true)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }
}