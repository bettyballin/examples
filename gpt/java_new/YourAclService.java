import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@Service
public class YourAclService {

    @Autowired
    private MutableAclService aclService;
    
    @Transactional
    public void addPermission() {
        // Your code to add permission
    }
}

// Assuming you want to define a Bean for PlatformTransactionManager in a configuration class
@Configuration
public class TransactionManagerConfig {

    @Bean
    public PlatformTransactionManager transactionManager() {
        // Return an instance of a class that implements PlatformTransactionManager
        return null; // Replace with actual transaction manager
    }
}