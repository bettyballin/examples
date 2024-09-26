import org.cometd.bayeux.server.BayeuxServerImpl;
import org.cometd.bayeux.server.ServerChannel;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.annotation.Listener;
import org.cometd.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service("Temp1147Service")
public class Temp1147 {
    @Autowired
    private BayeuxServerImpl bayeux;

    @Autowired
    private PersonService personService;

    public static void main(String[] args) {
        // Main method to initiate the service
    }

    @Listener("/service/testlistener/{id}")
    public void testlistener(ServerSession remote, ServerMessage message, @Param("id") String id) {
        try {
            // Retrieve the JSESSIONID from request headers
            Map<String, Object> ext = (Map<String, Object>) message.getExt();
            if (ext != null && ext.containsKey("jsessionid")) {
                HttpServletRequest req = ((BayeuxServerImpl) bayeux).getHttpSession().getRequest();
                String jsessionid = (String) ext.get("jsessionid");
                // Set the JSESSIONID as a request attribute for Spring Security to use.
                req.setAttribute("cometd.jsessionid", jsessionid);
            }

            Person user = this.personService.getCurrentlyAuthenticatedUser();
            Map<String, Object> data = message.getDataAsMap();
            System.out.println("currentlyAuthenticatedUser: " + user + " Transmitted Data in map:" + data.get("name"));
            Map<String, Object> output = new HashMap<>();
            output.put("name", user.getFirstName());
            ServerChannel serverChannel = bayeux.createChannelIfAbsent("/person/" + id).getReference();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}