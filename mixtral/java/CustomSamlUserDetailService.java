import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.security.saml.SAMLCredential;

import java.util.List;
import java.util.Map;

public class CustomSamlUserDetailService implements SAMLUserDetailsService {

    @Override
    public Object loadUserBySAML(SAMLCredential cred) throws UsernameNotFoundException, PreAuthenticatedCredentialsNotFoundException {
        Map<String, List<Object>> attributes = cred.getAttributes();

        // Extract the required attribute
        String surname = (String) attributes.get("SurName").get(0);

        return new CustomUserDetails(surname);
    }
}

class CustomUserDetails {
    private String surname;

    public CustomUserDetails(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "surname='" + surname + '\'' +
                '}';
    }
}