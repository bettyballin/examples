import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

@Controller
public class Temp519 {

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();  // Get the username

        User user = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username", User.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
        if(user != null) {
            Role role = user.getRole();

            model.addAttribute("username", username);
            model.addAttribute("roleName", role.getName());
        }
        return "index";
    }
}

@Entity
@Table(name = "users")
class User {
    private String username;
    private Role role;

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }
}

@Entity
@Table(name = "roles")
class Role {
    private String name;

    public String getName() {
        return name;
    }
}