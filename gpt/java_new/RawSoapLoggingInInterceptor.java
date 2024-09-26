import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

public class RawSoapLoggingInInterceptor extends AbstractSoapInterceptor {
    public RawSoapLoggingInInterceptor() {
        super(Phase.PRE_PROTOCOL);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        // Log the raw incoming XML here, before decryption
    }
}

class RawSoapLoggingOutInterceptor extends AbstractSoapInterceptor {
    public RawSoapLoggingOutInterceptor() {
        super(Phase.PRE_STREAM);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        // Log the raw outgoing XML here, before it is sent
    }
}