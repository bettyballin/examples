import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;

public class MyTestClass1 {

    private MockMvc mockMvc;
    private MyController myController; // Assuming MyController class exists

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        myController = new MyController(); // Instantiate MyController or mock it
        mockMvc = MockMvcBuilders
                    .standaloneSetup(myController)
                    .apply(SecurityMockMvcConfigurers.springSecurity())
                    .build();
    }
}