import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SpringConfig {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new SpringSecurityAuditAware();
    }
}

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class SpringSecurityAuditAware implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        // Implement logic to fetch the current user's ID
        // e.g., from Spring Security context
        return Optional.of(1L);  // Just a placeholder
    }
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyEntityRepository myEntityRepository;

    @Transactional
    public void saveEntity(MyEntity entity) {
        Long userId = 1L; // Fetch user ID from Spring Security context
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        entity.setCreatedBy(user);
        entity.setUpdatedBy(user);
        myEntityRepository.save(entity);
    }
}

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
}

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User updatedBy;

    // other fields, getters, and setters
}

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // other fields, getters, and setters
}