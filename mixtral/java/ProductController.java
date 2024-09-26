import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Controller
public class ProductController {

    // Assuming productRepo is defined and properly initialized.
    private ProductRepository productRepo;

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ModelAndView findProduct(@PathVariable("productId") long productId, RedirectAttributes redirectAttributes, Model model) {
        // Assuming Product class and its getVisits method are defined.
        Product p = productRepo.findById(productId);
        productRepo.updateVisit(productId, p.getVisits() + 1);

        // Additional logic to handle the request and model.
        // ...

        return new ModelAndView("productView", "product", p);
    }

    // Assuming ProductRepository and Product classes are defined somewhere in the project.
    public interface ProductRepository {
        Product findById(long id);
        void updateVisit(long id, int newVisitCount);
    }

    public class Product {
        private long id;
        private int visits;

        // Getters and setters

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getVisits() {
            return visits;
        }

        public void setVisits(int visits) {
            this.visits = visits;
        }
    }
}