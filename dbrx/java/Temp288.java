import java.util.Set;
import javax.security.auth.Subject;

public class Temp288 {
    public static void main(String[] args) {
        // Create a sample Subject with some private credentials for demonstration purposes
        Subject subject = new Subject();
        subject.getPrivateCredentials().add(new LDAPUserAttributeCredential("exampleAttribute", "exampleValue"));

        Set<Object> privateCreds = subject.getPrivateCredentials();
        for (Object cred : privateCreds) {
            if (cred instanceof LDAPUserAttributeCredential) {
                LDAPUserAttributeCredential ldapAttrCred = (LDAPUserAttributeCredential) cred;
                String attrName = ldapAttrCred.getAttributeName();
                Object attrValue = ldapAttrCred.getAttributeValue();
                // Do something with the attribute value
                System.out.println("Attribute Name: " + attrName);
                System.out.println("Attribute Value: " + attrValue);
            }
        }
    }
}

// Dummy LDAPUserAttributeCredential class to make the code executable
class LDAPUserAttributeCredential {
    private String attributeName;
    private Object attributeValue;

    public LDAPUserAttributeCredential(String attributeName, Object attributeValue) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public Object getAttributeValue() {
        return attributeValue;
    }
}