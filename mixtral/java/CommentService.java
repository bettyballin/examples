import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class CommentService {

    // ...

    @PreAuthorize("isAuthenticated()")
    public void addComment(Product product, String comment) {
        // Add logic
    }

}

// In your controller

@Controller
public class ProductController {

    @Autowired
    private CommentService service;

    //...

    @PostMapping("/products/{productId}/comments/add")
    public String save(@PathVariable("productId") Long productId,
                       @RequestParam("comment") String comment) {
        Product product = new Product(); // You need to fetch the actual product by productId
        product.setId(productId);
        service.addComment(product, comment);

        return "redirect:/";
    }

}

// Dummy Product class for demonstration
class Product {
    private Long id;
    // other fields, getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}