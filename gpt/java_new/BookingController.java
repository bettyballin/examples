import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
public class BookingController {

    private final BookRepository bookRepo;
    private final BookingRepository bookingsRepo;

    public BookingController(BookRepository bookRepo, BookingRepository bookingsRepo) {
        this.bookRepo = bookRepo;
        this.bookingsRepo = bookingsRepo;
    }

    @PostMapping("/homepage/save-borrow")
    public String saveBorrow(Bookings bk, HttpServletRequest request, Authentication auth) {
        request.setAttribute("mode", "MODE_BORROW");
        if (bookRepo.existsById(bk.getBookId())) {
            bk.setUser(auth.getName());
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            String role = authorities.iterator().next().getAuthority();
            double fine = calculateFine(role);
            bk.setFine(fine);
            bk.setUserRole(role);
            bookingsRepo.save(bk);
        }
        return "redirect:/homepage";
    }

    private double calculateFine(String role) {
        // Placeholder for fine calculation logic
        return 0.0;
    }
}