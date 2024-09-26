import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.WSSecurityException;
import org.apache.wss4j.common.ext.WSSecurityException.ErrorCode;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.engine.WSSecurityEngine;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecSignature;
import org.apache.wss4j.dom.message.WSSecTimestamp;
import org.apache.wss4j.dom.util.WSSecurityUtil;
import org.apache.xml.security.signature.XMLSignature;
import org.w3c.dom.Document;

import javax.xml.crypto.dsig.DigestMethod;
import java.security.cert.X509Certificate;
import java.util.List;

public class DocumentSecurity {

    private Crypto crypto;

    public DocumentSecurity(Crypto crypto) {
        this.crypto = crypto;
    }

    public Document signWsSec(Document doc) throws WSSecurityException {
        if (crypto == null) throw new WSSecurityException(ErrorCode.FAILURE, "noCryptoInstance");

        X509Certificate[] issuerCerts = crypto.getX509Certificates(null);

        WSSecHeader secHeader = new WSSecHeader(doc);
        secHeader.insertSecurityHeader();

        WSSecTimestamp timestamp = new WSSecTimestamp(secHeader);
        timestamp.setTimeToLive(300);
        timestamp.build();

        WSSecSignature sign = new WSSecSignature(secHeader);
        sign.setX509Certificate(issuerCerts[0]);
        sign.setUseSingleCertificate(true);

        org.apache.xml.security.Init.init();
        sign.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE);
        sign.setSignatureAlgorithm(XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA1);
        sign.setDigestAlgo(DigestMethod.SHA1);

        sign.prepare(crypto);
        List<javax.xml.crypto.dsig.Reference> referenceList = sign.addReferencesToSign(WSSecurityUtil.getDefaultEncryptionPart(doc));
        sign.computeSignature(referenceList);
        sign.appendBSTElementToHeader();

        return doc;
    }

    public void setCrypto(Crypto crypto) {
        this.crypto = crypto;
    }

    public Crypto getCrypto() {
        return this.crypto;
    }
}