import org.springframework.stereotype.Service;

@Service
public class ScopeService {

    private final ScopeRepository scopeRepository;
    private final BcmsSecurityService bcmsSecurityService;

    public ScopeService(ScopeRepository scopeRepository, BcmsSecurityService bcmsSecurityService) {
        this.scopeRepository = scopeRepository;
        this.bcmsSecurityService = bcmsSecurityService;
    }

    // Rest of the class implementation...
}