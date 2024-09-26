import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.ws.security.WSHandlerConstants;
import org.apache.ws.security.handler.WSHandlerResult;
import org.apache.ws.security.handler.WSSecurityEngineResult;

import javax.security.auth.Subject;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

public class SpringSecurityInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    private ThreadLocal<Subject> currentSubject = new ThreadLocal<>();

    public SpringSecurityInterceptor() {
        super(Phase.PRE_PROTOCOL);
        getAfter().add(WSS4JInInterceptor.class.getName());
        getAfter().add(PolicyBasedWSS4JInInterceptor.class.getName());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        try {
            Subject subject = currentSubject.get();
            if (subject == null) {
                subject = new Subject();
                currentSubject.set(subject);
            }
            List<Object> results = (List<Object>) message.get(WSHandlerConstants.RECV_RESULTS);
            if (results == null) {
                return;
            }
            for (Iterator<Object> iter = results.iterator(); iter.hasNext(); ) {
                WSHandlerResult hr = (WSHandlerResult) iter.next();
                if (hr == null || hr.getResults() == null) {
                    return;
                }

                for (Iterator<WSSecurityEngineResult> it = hr.getResults().iterator(); it.hasNext(); ) {
                    WSSecurityEngineResult er = it.next();

                    if (er != null && er.get(WSSecurityEngineResult.TAG_X509_CERTIFICATE) instanceof X509Certificate) {
                        X509Certificate cert = (X509Certificate) er.get(WSSecurityEngineResult.TAG_X509_CERTIFICATE);
                        // TODO do something with the certificate
                    }
                }
            }
            message.put(Subject.class, subject);
        } catch (java.lang.reflect.UndeclaredThrowableException e) {
            Throwable undeclared = e.getUndeclaredThrowable();
            if (undeclared != null && undeclared instanceof java.lang.reflect.InvocationTargetException) {
                throw new Fault(
                        ((java.lang.reflect.InvocationTargetException) undeclared)
                                .getTargetException());
            }
        } finally {
            currentSubject.set(null);
        }
    }
}