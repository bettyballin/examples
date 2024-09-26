import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;

// Assuming the following variables are already defined and initialized in your context
TransactionTemplate tt = new TransactionTemplate(transactionManager);
final Class<?> clazz; // The class for which the ACL is being deleted
final SecuredObject securedObject; // The secured object instance
final JdbcMutableAclService aclService; // Your ACL service instance

tt.execute(new TransactionCallbackWithoutResult() {
    @Override
    protected void doInTransactionWithoutResult(TransactionStatus status) {
        ObjectIdentity oid = new ObjectIdentityImpl(clazz.getCanonicalName(), securedObject.getId());
        // your aclService operation here:
        aclService.deleteAcl(oid, true);
    }
}