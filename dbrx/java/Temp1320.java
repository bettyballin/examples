import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.Reader;

public class Temp1320 {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();

            SoapHeader soapHeader = getSoapHeader();
            InputSource inputSource = new InputSource(soapHeader.getSource());

            DefaultHandler yourCustomHandler = new DefaultHandler();
            saxParser.parse(inputSource, yourCustomHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SoapHeader getSoapHeader() {
        return new SoapHeader();
    }

    private static class SoapHeader {
        public Reader getSource() {
            return new java.io.StringReader("<soapHeader></soapHeader>");
        }
    }
}