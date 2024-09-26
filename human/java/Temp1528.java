import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Temp1528 {
    public static void main(String[] args) {
        // For demonstration purposes, we will simulate the calls to the service here.
        // In a real application, these methods would be called in the context of a web application or similar.
        MyItemService myItemService = new MyItemService(new MyItemDao());

        // Simulating a security context
        SecurityContextHolder.getContext().setAuthentication(new MockAuthentication());

        // Simulating service calls
        MyItem item = myItemService.getMyItem(1L);
        System.out.println("Retrieved item: " + item);

        myItemService.deleteMyItem(item);
        System.out.println("Deleted item: " + item);
    }
}

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig {
    // Security configuration goes here
    // For simplicity, this is left empty.
}

@Service
class MyItemService {
    private final MyItemDao dao;

    public MyItemService(MyItemDao dao) {
        this.dao = dao;
    }

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    public MyItem getMyItem(Long id) {
        return dao.getMyItem(id);
    }

    @PreAuthorize("hasPermission(#toDelete, 'DELETE')")
    public void deleteMyItem(MyItem toDelete) {
        dao.delete(toDelete);
    }
}

@Component
class MyItemDao {
    public MyItem getMyItem(Long id) {
        return new MyItem(id, "ItemName");
    }

    public void delete(MyItem item) {
        // simulate delete
    }
}

class MyItem {
    private Long id;
    private String name;

    public MyItem(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyItem{id=" + id + ", name='" + name + "'}";
    }
}

class MockAuthentication extends org.springframework.security.authentication.UsernamePasswordAuthenticationToken {
    public MockAuthentication() {
        super("user", "password", java.util.Collections.emptyList());
    }

    @Override
    public Object getPrincipal() {
        return new UserDetails() {
            @Override
            public java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
                return java.util.Collections.emptyList();
            }

            @Override
            public String getPassword() {
                return "password";
            }

            @Override
            public String getUsername() {
                return "user";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}