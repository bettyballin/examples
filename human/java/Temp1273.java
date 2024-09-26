import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Temp1273 {
    public static void main(String[] args) {
        XmlImport();
    }

    public static void XmlImport() {
        try {
            String xmlPubKey = "<RSAKeyValue>\n\t<Modulus>AI0hSZ3hcfJHv1TPSIkT0XeW/HMPPFJMw4/aX5NxfhyVacpb5u6rucDztVNG1pXaBdya9OdO1+mGG250y+QuqP/70uu5QMcMEpCdp8xl0i+cUN9+fHDzse4XR/Kdrl3pKAefSR5QQX8xBScjTO+H+9fXVrrU9TQU6WXmahQnDwDJ</Modulus>\n\t<Exponent>AQAB</Exponent>\n</RSAKeyValue>\n";

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            Document doc = dbf.newDocumentBuilder().parse(new java.io.ByteArrayInputStream(xmlPubKey.getBytes()));
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            String modulusBase64 = root.getElementsByTagName("Modulus").item(0).getTextContent();
            String exponentBase64 = root.getElementsByTagName("Exponent").item(0).getTextContent();

            byte[] modulusBytes = Base64.getDecoder().decode(modulusBase64);
            byte[] exponentBytes = Base64.getDecoder().decode(exponentBase64);

            java.math.BigInteger modulus = new java.math.BigInteger(1, modulusBytes);
            java.math.BigInteger exponent = new java.math.BigInteger(1, exponentBytes);

            RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, exponent);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            java.security.PublicKey pub = factory.generatePublic(spec);

            System.out.println("Public Key: " + pub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}