import org.springframework.security.acls.domain.BasicLookupStrategy;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.acls.sid.SidRetrievalStrategy;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.access.PermissionEvaluator;
import java.io.Serializable;
import java.util.List;

public class CustomAclLookupStrategy extends BasicLookupStrategy {

    public CustomAclLookupStrategy(AclService aclService, 
                                   PermissionEvaluator permissionEvaluator, 
                                   SidRetrievalStrategy sidRetrievalStrategy, 
                                   PermissionGrantingStrategy permissionGrantingStrategy) {
        super(aclService, permissionEvaluator, sidRetrievalStrategy, permissionGrantingStrategy);
    }

    @Override
    public List<ObjectIdentity> readObjectIdentifiersByIds(List<Sid> sids, List<Serializable> ids) throws NotFoundException {
        // Set the transaction mode to readOnly before executing the query.
        TransactionSynchronizationManager.setReadOnly(true);

        try {
            return super.readObjectIdentifiersByIds(sids, ids);
        } finally {
            // Reset the transaction mode after completing the operation.
            TransactionSynchronizationManager.setReadOnly(false);
        }
    }
}