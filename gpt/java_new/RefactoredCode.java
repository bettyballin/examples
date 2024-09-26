import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ws.policy.PolicyEngine;
import org.apache.neethi.Policy;
import org.apache.neethi.ExactlyOne;
import org.apache.neethi.All;
import org.apache.cxf.ws.security.policy.model.AlgorithmSuite;
import org.apache.wss4j.policy.SPConstants.AlgorithmSuiteType;

import java.net.URL;

public class RefactoredCode {
    public static void main(String[] args) throws Exception {
        URL wsdlURL = new URL("http://example.com/service?wsdl");
        QName serviceName = new QName("http://example.com/", "MyService");
        QName portName = new QName("http://example.com/", "MyPort");
        
        Service service = Service.create(wsdlURL, serviceName);
        IService port = service.getPort(portName, IService.class);

        Client client = ClientProxy.getClient(port);

        PolicyEngine policyEngine = client.getBus().getExtension(PolicyEngine.class);
        Policy policy = new Policy();
        ExactlyOne exactlyOne = new ExactlyOne();
        All all = new All();

        AlgorithmSuite algorithmSuite = new AlgorithmSuite();
        algorithmSuite.setAlgorithmSuiteType(AlgorithmSuiteType.Basic256Sha256Rsa15);

        all.addAssertion(algorithmSuite);
        exactlyOne.addPolicyComponent(all);
        policy.addPolicyComponent(exactlyOne);

        policyEngine.setClientEndpointPolicy(client.getEndpoint(), policy);
    }
    
    interface IService {
        // Define the interface methods
    }
}