import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class Temp1071 {
    public static void main(String[] args) {
        // Spring Boot application entry point
    }
}

interface ReportRepository extends CrudRepository<Report, Long> {
    @Query("SELECT r FROM Report r WHERE r.user.id = ?#{principal?.id}")
    List<Report> findAllByUser();
}

@Controller
class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/reports")
    @PreAuthorize("hasRole('USER')")
    public List<Report> getReports() {
        return reportRepository.findAllByUser();
    }
}

class Report {
    // Assuming Report has a User field named "user"
    private User user;

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

class User {
    private Long id;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}