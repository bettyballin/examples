import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "auth_user")
public class User implements UserDetails {

   @Id
   @Column
   private String id;

   @Column(nullable = false, unique = true)
   private String name;

   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private Set<Role> roles = new HashSet<Role>();

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
     Set<GrantedAuthority> authList = new HashSet<GrantedAuthority>();

     for (Role role : roles) {
       authList.add(new SimpleGrantedAuthority(role.getName()));
     }

     return authList;
   }

   // Other methods required by UserDetails interface
   @Override
   public String getPassword() {
     return null; // Implement as per your requirement
   }

   @Override
   public String getUsername() {
     return this.name;
   }

   @Override
   public boolean isAccountNonExpired() {
     return true;
   }

   @Override
   public boolean isAccountNonLocked() {
     return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
     return true;
   }

   @Override
   public boolean isEnabled() {
     return true;
   }

   // Getters and Setters for id, name, and roles
   public String getId() {
     return id;
   }

   public void setId(String id) {
     this.id = id;
   }

   public String getName() {
     return name;
   }

   public void setName(String name) {
     this.name = name;
   }

   public Set<Role> getRoles() {
     return roles;
   }

   public void setRoles(Set<Role> roles) {
     this.roles = roles;
   }
}

@Entity(name = "role")
class Role {

   @Id
   @Column
   private String id;

   @Column(nullable = false, unique = true)
   private String name;

   // Getters and Setters
   public String getId() {
     return id;
   }

   public void setId(String id) {
     this.id = id;
   }

   public String getName() {
     return name;
   }

   public void setName(String name) {
     this.name = name;
   }
}