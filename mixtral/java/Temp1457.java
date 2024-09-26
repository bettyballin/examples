import com.ibm.websphere.cache.ObjectCache;
import com.ibm.websphere.cache.ObjectCacheFactory;

public class Temp1457 {
    public static void main(String[] args) {

        // Mocking SAML response attributes for the example
        SAMLResponseAttributes samlResponseAttributes = new SAMLResponseAttributes();
        samlResponseAttributes.setAttributeValue("firstname", "John");

        ObjectCache cache = ObjectCacheFactory.getObjectCache("myDynamicCache");

        String userId = "user123";

        UserProfile userProfile = new UserProfile();

        // Populate the attributes from SAML response
        userProfile.setFirstName(samlResponseAttributes.getAttributeValue("firstname"));

        cache.put("/users/" + userId, userProfile);

        // Retrieve and print the cached user profile
        UserProfile cachedUserProfile = (UserProfile) cache.get("/users/" + userId);
        System.out.println("Cached User First Name: " + cachedUserProfile.getFirstName());
    }
}

class UserProfile {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

// Mock SAMLResponseAttributes class for the example
class SAMLResponseAttributes {
    private String firstName;

    public String getAttributeValue(String attributeName) {
        if ("firstname".equals(attributeName)) {
            return firstName;
        }
        return null;
    }

    public void setAttributeValue(String attributeName, String value) {
        if ("firstname".equals(attributeName)) {
            this.firstName = value;
        }
    }
}