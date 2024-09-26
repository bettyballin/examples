import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@SpringBootApplication
public class Temp774 {

    public static void main(String[] args) {
        SpringApplication.run(Temp774.class, args);
    }

    @Bean
    public UsernamePasswordAuthenticationFilter authenticationFilter() {
        return new UsernamePasswordAuthenticationFilter();
    }

    @Entity
    public static class Report {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String owner; // Assuming owner is a String representing the username

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }

    @Bean
    public ReportRepository reportRepository() {
        return new ReportRepository();
    }

    public interface ReportRepository extends JpaRepository<Report, Long> {

        @Query("SELECT r FROM Report r WHERE r.owner = ?#{principal.username}")
        List<Report> findReportsByCurrentUser();
    }

    @Bean
    public Object runQuery(ReportRepository reportRepository) {
        // For demonstration purposes, let's assume this method is called after the application starts
        List<Report> reports = reportRepository.findReportsByCurrentUser();
        reports.forEach(report -> System.out.println("Report ID: " + report.getId() + ", Owner: " + report.getOwner()));
        return new Object();
    }

    // Assuming a dummy principal for testing purposes
    static {
        SecurityContextHolder.getContext().setAuthentication(new DummyAuthentication("testUser"));
    }

    static class DummyAuthentication implements org.springframework.security.core.Authentication {

        private final String username;

        DummyAuthentication(String username) {
            this.username = username;
        }

        @Override
        public String getName() {
            return username;
        }

        // Other overridden methods would go here, but we'll leave them unimplemented for brevity
        @Override public Object getPrincipal() { return new org.springframework.security.core.userdetails.User(username, "", List.of()); }
        @Override public Object getCredentials() { return null; }
        @Override public Object getDetails() { return null; }
        @Override public List getAuthorities() { return List.of(); }
        @Override public boolean isAuthenticated() { return true; }
        @Override public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {}
    }
}