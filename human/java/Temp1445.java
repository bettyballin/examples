import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Temp1445 {

    @Autowired
    private DbDAO dbDAO; // Assuming you have a DAO class for database operations

    @RequestMapping(value = "/")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // Get the username

        // Here you connect to your database and pull out the relevant entity object
        Data data = dbDAO.findByUsername(username);

        // Now pull the person object and allocate it to a new object
        Person person = data.getPerson();

        // Do your transformations or queries on the person object
        // Or pass it to your view layer via model
        model.addAttribute("person", person);
        model.addAttribute("username", username);

        return "index";
    }

    // Assuming you have a Data class and a Person class
    public static class Data {
        private Person person;

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }
    }

    public static class Person {
        // Your fields and methods here
    }

    // Assuming you have a DbDAO class for database operations
    public interface DbDAO {
        Data findByUsername(String username);
    }
}