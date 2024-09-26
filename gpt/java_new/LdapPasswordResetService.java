import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.directory.ModificationItem;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;

@Service
public class LdapPasswordResetService {

    private final LdapTemplate ldapTemplate;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LdapPasswordResetService(LdapTemplate ldapTemplate, PasswordEncoder passwordEncoder) {
        this.ldapTemplate = ldapTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    public void resetPassword(String userDn, String newPassword) {
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        ModificationItem[] mods = new ModificationItem[1];
        mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("userPassword", encodedNewPassword));
        ldapTemplate.modifyAttributes(userDn, mods);
    }
}