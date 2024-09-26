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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = {SampleServiceImplTest.TestConfiguration.class})
public class SampleServiceImplTest {

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    protected static class TestConfiguration {
        @Bean
        @Primary
        public SampleDaoImpl getSampleDaoImpl() {
            return mock(SampleDaoImpl.class);
        }

        @Bean
        public SampleService sampleService() {
            return new SampleServiceImpl(getSampleDaoImpl());
        }
    }

    @Autowired
    private SampleDaoImpl dao;

    @Autowired
    private SampleService svc;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = AccessDeniedException.class)
    @WithMockUser(username = "usr", roles = {"ROOT"})
    public void doItDeniedTest() {
        svc.doIt();
    }

    @Test
    @WithMockUser(username = "usr", roles = {"USR"})
    public void doItTest() {
        Boolean ctrl = Boolean.FALSE;
        Mockito.when(dao.getValue()).thenReturn(ctrl);

        Boolean rt = svc.doIt();
        assertEquals(ctrl, rt);
    }
}

interface SampleDaoImpl {
    Boolean getValue();
}

interface SampleService {
    Boolean doIt();
}

class SampleServiceImpl implements SampleService {

    private final SampleDaoImpl dao;

    public SampleServiceImpl(SampleDaoImpl dao) {
        this.dao = dao;
    }

    @PreAuthorize("hasRole('USR')")
    @Override
    public Boolean doIt() {
        return dao.getValue();
    }
}