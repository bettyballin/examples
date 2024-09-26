import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.staxutils.StaxUtils;
import org.apache.cxf.staxutils.PrettyPrintXMLStreamWriter;
import org.slf4j.Logger;

import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class CleartextLogger extends AbstractSoapInterceptor {
    private static final String LOG_SETUP = CleartextLogger.class.getName() + ".log-setup";
    private Logger logger;

    public CleartextLogger(Logger logger) {
        super(Phase.POST_PROTOCOL);
        this.logger = logger;
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        try {
            boolean logged = message.containsKey(LOG_SETUP);
            if (!logged) {
                message.put(LOG_SETUP, Boolean.TRUE);
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                SOAPMessage smsg = message.getContent(SOAPMessage.class);
                if(smsg != null)  {
                    smsg.writeTo(bout);
                    log(bout.toString());
                } else {
                    logger.warn("Es gab keinen verschlüsselten Inhalt zu loggen");
                }
            }
        } catch (SOAPException | IOException e) {
            e.printStackTrace();
        }
    }

    private void log(String xml) {
        try (StringReader in = new StringReader(xml);
             StringWriter swriter = new StringWriter()) {
            XMLStreamWriter xwriter = StaxUtils.createXMLStreamWriter(swriter);
            xwriter = new PrettyPrintXMLStreamWriter(xwriter, 2);
            StaxUtils.copy(new StreamSource(in), xwriter);
            xwriter.flush();

            String result = swriter.toString();
            logger.debug(result);
        } catch (XMLStreamException ignored) {
        }
    }
}