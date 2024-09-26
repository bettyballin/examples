import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternalSomeService extends SomeService {

    @Autowired
    public InternalSomeService() {
        super(false);
    }

    // ... other methods
}

public class SomeService {
    private boolean someFlag;

    public SomeService(boolean someFlag) {
        this.someFlag = someFlag;
    }

    // ... other methods
}


Note: I added `public` access modifier to `SomeService` class.