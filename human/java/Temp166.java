import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.MutableAclService;

public class Temp166 {

    private static PlatformTransactionManager transactionManager;
    private static MutableAclService aclService;
    private static Class<?> clazz;
    private static SecuredObject securedObject;

    public static void main(String[] args) {
        TransactionTemplate tt = new TransactionTemplate(transactionManager);
        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                ObjectIdentity oid = new ObjectIdentityImpl(clazz.getCanonicalName(), securedObject.getId());
                // your aclService operation here:
                aclService.deleteAcl(oid, true);
            }
        });
    }

    // Dummy placeholder for SecuredObject class
    private static class SecuredObject {
        private Long id;

        public Long getId() {
            return id;
        }
    }
}