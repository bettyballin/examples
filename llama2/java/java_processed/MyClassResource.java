// MyClassResource.java
import javax.ejb.EJB;
import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.annotations.ApiOperation;

@Path("/myclass")
public class MyClassResource {

    @EJB
    private MyClassService myClassService;

    @POST
    @Path("/api/v1/service")
    @Produces({"application/json"})
    @ApiOperation(value = "Processes Conn", response = ResponseClass.class, responseContainer = "ResponseClass", hidden = true)
    public ResponseClass sync(@BeanParam MyClassRequest request) throws Exception {
        myClassService.processFeed(request);
        return new RelayResponse(HttpStatuses.ACCEPTED.getStatus());
    }
}

// MyClassRequest.java
import javax.validation.Valid;

public class MyClassRequest extends RelayRequest {

    public MyClassRequest() {
        super.setMessageType("not required");
    }

    private String myData;
    private String conneRid;
    private String connectionCreatedDate;

    // Getters and setters
    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }

    public String getConneRid() {
        return conneRid;
    }

    public void setConneRid(String conneRid) {
        this.conneRid = conneRid;
    }

    public String getConnectionCreatedDate() {
        return connectionCreatedDate;
    }

    public void setConnectionCreatedDate(String connectionCreatedDate) {
        this.connectionCreatedDate = connectionCreatedDate;
    }
}

// Supporting Classes
public class RelayResponse extends ResponseClass {
    private int status;
    
    public RelayResponse(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

public class RelayRequest {
    private String messageType;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}

public class ResponseClass {
    // Response class implementation
}

public class HttpStatuses {
    public static final HttpStatus ACCEPTED = new HttpStatus(202);

    public static class HttpStatus {
        private int status;

        public HttpStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }
}

public interface MyClassService {
    void processFeed(MyClassRequest request) throws Exception;
}