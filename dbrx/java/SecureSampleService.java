import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

public interface ISampleService {
    boolean doIt();
}

@Service
@Primary
public class SecureSampleService implements ISampleService {
    private final ISampleService delegate;

    public SecureSampleService(@Qualifier("sampleService") ISampleService delegate) {
        this.delegate = delegate;
    }

    @Override
    @PreAuthorize("hasRole('USR')")
    public boolean doIt() {
        return delegate.doIt();
    }
}

@Service("sampleService")
class SampleService implements ISampleService {
    @Override
    public boolean doIt() {
        // Implementation of the service method
        return true;
    }
}