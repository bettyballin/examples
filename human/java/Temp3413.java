import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp3413 {

    public static void main(String[] args) {
        // Example usage
    }

    public static List<Predicate> getPredicatesForRestrictingDataByUser(Root<BankAccount> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        // I realized in your edit that you are returning the user id instead of the user object.
        // There is nothing wrong with it but you are losing a valuable information: if you provide
        // a convenient UserDetails implementation you can have direct access to the authorities a user has, etc
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Restrict data based on actual permissions

        // If the user is an admin, we assume that he/she can see everything, and we will no return any predicates
        if (hasAuthority(user, "ADMINISTRATION")) {
            return Collections.emptyList();
        }

        // Let's introduce the accounting manager role.
        // Suppose that an accounting manager can see all the accounts in his/her department
        if (hasAuthority(user, "ACCOUNTING_MANAGER")) {
            return Collections.singletonList(cb.equal(root.get(BankAccount_.accountingDeparment), user.getDepartment()));
        }

        // In any other case, a user can only see the bank account if he/she is the account owner
        return Collections.singletonList(cb.equal(root.get(BankAccount_.owner), user.getId()));
    }

    private static boolean hasAuthority(User user, String authority) {
        return user.getAuthorities().stream()
            .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority));
    }

    // Dummy classes to make the code compile
    static class BankAccount {
        // Define your fields and methods here
    }

    static class BankAccount_ {
        public static volatile String accountingDeparment;
        public static volatile String owner;
    }

    static class User {
        private String id;
        private String department;
        private List<GrantedAuthority> authorities;

        public String getId() {
            return id;
        }

        public String getDepartment() {
            return department;
        }

        public List<GrantedAuthority> getAuthorities() {
            return authorities;
        }
    }

    interface GrantedAuthority {
        String getAuthority();
    }
}