import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PermissionService {

    private final MutableAclService aclService;

    @Autowired
    public PermissionService(MutableAclService aclService) {
        this.aclService = aclService;
    }

    public void revokeOwnPermission(ObjectIdentity oid, Authentication authentication, Permission permission) {
        MutableAcl acl = (MutableAcl) aclService.readAclById(oid);
        Sid sid = new PrincipalSid(authentication);

        List<AccessControlEntry> entries = acl.getEntries();
        for (int i = 0; i < entries.size(); i++) {
            AccessControlEntry entry = entries.get(i);
            if (entry.getSid().equals(sid) && entry.getPermission().equals(permission)) {
                acl.deleteAce(i);
                break;
            }
        }
        aclService.updateAcl(acl);
    }
}