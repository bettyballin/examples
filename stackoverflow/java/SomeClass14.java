import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

public class SomeClass14 {

    public static List<Predicate> getPredicatesForRestrictingDataByUser(Root<BankAccount> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // If the user is an admin, we assume that he/she can see everything, and we will no return any predicates
        if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMINISTRATION"))) {
            return Collections.emptyList();
        }

        // Suppose that an accounting manager can see all the accounts in his/her department
        if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ACCOUNTING_MANAGER"))) {
            return Collections.singletonList(cb.equal(root.get("accountingDepartment"), user.getUsername())); // Assuming the department is stored as a username
        }

        // In any other case, a user can only see the bank account if he/she is the account owner
        return Collections.singletonList(cb.equal(root.get("owner"), user.getUsername()));
    }
}