import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class MyDetailsService implements UserDetailsService {

  @Autowired
  private HttpServletRequest request;

  //...

}