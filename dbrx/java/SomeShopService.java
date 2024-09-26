import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeShopService {

    private final ServiceCoreClient serviceCoreClient;

    @Autowired
    public SomeShopService(ServiceCoreClient serviceCoreClient) {
        this.serviceCoreClient = serviceCoreClient;
    }

    public void someMethod(String jwtToken) {
        // Call insertData with the JWT bearer token and data object.
        Data data = new Data();
        serviceCoreClient.insertData(jwtToken, data);
    }
}

class ServiceCoreClient {
    public void insertData(String jwtToken, Data data) {
        // Implementation here
    }
}

class Data {
    // Data fields and methods here
}



// Add the missing import statement and make Data and ServiceCoreClient public
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeShopService {

    private final ServiceCoreClient serviceCoreClient;

    @Autowired
    public SomeShopService(ServiceCoreClient serviceCoreClient) {
        this.serviceCoreClient = serviceCoreClient;
    }

    public void someMethod(String jwtToken) {
        // Call insertData with the JWT bearer token and data object.
        Data data = new Data();
        serviceCoreClient.insertData(jwtToken, data);
    }
}

public class ServiceCoreClient {
    public void insertData(String jwtToken, Data data) {
        // Implementation here
    }
}

public class Data {
    // Data fields and methods here
}