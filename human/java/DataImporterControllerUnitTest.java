import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DataImporterController.class)
public class DataImporterControllerUnitTest {

    @MockBean
    private DataImporterService dataImporterService;

    @Autowired
    private MockMvc mockMvc;

    private static final String URI = "/your-uri-here";
    private static final String BODY = "{\"key\":\"value\"}";

    @BeforeEach
    public void setUp() {
        when(dataImporterService.doImport(BODY)).thenReturn("something");
    }

    @Test
    void doImportExpect200() throws Exception {
        mockMvc.perform(put(URI)
                .with(jwt().authorities(new SimpleGrantedAuthority("SCOPE_data:write")))
                .contentType(APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON_VALUE)
                .content(BODY))
                .andExpect(status().isOk());
    }
}