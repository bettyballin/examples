import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppApplication.class, SampleServiceImplTest.TestConfiguration.class})
@WebAppConfiguration
public class SampleServiceImplTest {

    @Configuration
    protected static class TestConfiguration {
        @Bean
        @Primary
        public SampleDaoImpl getSampleDaoImpl(){
            return Mockito.mock(SampleDaoImpl.class);
        }
    }

    @Autowired
    private SampleDaoImpl dao;

    @Autowired
    private SampleService svc;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this); 
    }   

    @Test(expected=AccessDeniedException.class)
    @WithMockUser(username="usr",roles={"ROOT"})
    public void doItDeniedTest() {
        svc.doIt();
    }

    @Test
    @WithMockUser(username="usr",roles={"USR"})
    public void doItTest() {
        Boolean ctrl = Boolean.FALSE;
        Mockito.when(dao.getValue()).thenReturn(ctrl);

        Boolean rt = svc.doIt();
        assertEquals(ctrl,rt);      
    }
}