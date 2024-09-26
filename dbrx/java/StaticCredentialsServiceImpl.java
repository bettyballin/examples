import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service("staticCreds")
@ConditionalOnProperty(name = "use.static.creds", havingValue = "true")
public class StaticCredentialsServiceImpl implements MyService {

    @Override
    public void doSomething() {
        // Use static credentials here.
    }
}

interface MyService {
    void doSomething();
}


Should be:


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service("staticCreds")
@ConditionalOnProperty(name = "use.static.creds", havingValue = "true")
public class StaticCredentialsServiceImpl implements MyService {

    @Override
    public void doSomething() {
        // Use static credentials here.
    }
}

public interface MyService {
    void doSomething();
}