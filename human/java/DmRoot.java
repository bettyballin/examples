import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.AdviceMode;
import org.springframework.util.Assert;

@Configuration
@PropertySource("file:${my.config}")
@ComponentScan(basePackages = {
        "com.my.filter", "com.my.controller", "com.my.registration"
})
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = false)
@Import({MySecurityConfigurer.class, MyWebConfigurer.class})
public class DmRoot {

    private final Environment env;
    private String dbUserModelPackage;
    private String dbAccountingModelPackage;

    @Autowired
    public DmRoot(Environment env) {
        Assert.notNull(env, "die Umgebungseinstellungen sind NULL");
        this.env = env;
        this.dbUserModelPackage = env.getProperty("my.userDbModel");
        this.dbAccountingModelPackage = env.getProperty("my.accountingDbModel");
    }

    // all my Spring beans
}