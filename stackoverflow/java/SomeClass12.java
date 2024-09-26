import java.util.List;

public class SomeClass12 {
    public void someMethod(UserEntity userEntity) {
        List<AuthoritiesEntity> roleList = userEntity.getAuthoritiesEntities(userEntity.getRoles());
    }
}

class UserEntity {
    // Assuming getRoles() and getAuthoritiesEntities() are methods within UserEntity class
    public List<Role> getRoles() {
        // implementation
        return null;
    }

    public List<AuthoritiesEntity> getAuthoritiesEntities(List<Role> roles) {
        // implementation
        return null;
    }
}

class AuthoritiesEntity {
    // Details of AuthoritiesEntity
}

class Role {
    // Details of Role
}