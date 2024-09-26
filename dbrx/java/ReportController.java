import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<Report> getReports() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // or whatever property you need from the principal object

        return reportService.getReportsByUser(username);
    }
}

// Assuming there is a Report class defined somewhere
class Report {
    // fields, getters, setters, etc.
}

// Assuming there is a ReportService class defined somewhere
import java.util.List;

public interface ReportService {
    List<Report> getReportsByUser(String username);
}

import java.util.List;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<Report> getReportsByUser(String username) {
        // Logic to fetch reports by username
        return null; // Placeholder
    }
}