import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

public class UserService4 implements UserDetailsService {
    private ApplicationContext applicationContext;
    private MongoOperations mongoOperations;

    public UserService4() {
        applicationContext = new AnnotationConfigApplicationContext(MongoConfig.class);
        mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = new Query(Criteria.where("username").is(username));
        MyUser myUser = mongoOperations.findOne(query, MyUser.class);
        if (myUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(myUser.getUsername(), myUser.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

    // Replace MyUser with the class representing the user entity in your system
    private static class MyUser {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}