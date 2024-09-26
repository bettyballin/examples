import javacard.framework.APDU;
import javacard.framework.Applet;
import javacard.framework.ISO7816;
import javacard.framework.ISOException;
import javacard.framework.JCSystem;
import javacard.framework.Util;
import javacard.security.KeyBuilder;
import javacard.security.RSAPublicKey;

public class Temp1428 extends Applet {
    private RSAPublicKey m_publicKey;

    protected Temp1428() {
        m_publicKey = (RSAPublicKey) KeyBuilder.buildKey(KeyBuilder.TYPE_RSA_PUBLIC, KeyBuilder.LENGTH_RSA_2048, false);
    }

    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new Temp1428().register();
    }

    public void process(APDU apdu) {
        byte[] buffer = apdu.getBuffer();
        if (selectingApplet()) return;

        switch (buffer[ISO7816.OFFSET_INS]) {
            case (byte) 0x00:
                getExponent(apdu);
                break;
            case (byte) 0x01:
                getModulus(apdu);
                break;
            default:
                ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
        }
    }

    private void getExponent(APDU apdu) {
        byte[] buffer = apdu.getBuffer();
        short length = m_publicKey.getExponent(buffer, ISO7816.OFFSET_CDATA);
        apdu.setOutgoingAndSend(ISO7816.OFFSET_CDATA, length);
    }

    private void getModulus(APDU apdu) {
        byte[] buffer = apdu.getBuffer();
        short length = m_publicKey.getModulus(buffer, ISO7816.OFFSET_CDATA);
        apdu.setOutgoingAndSend(ISO7816.OFFSET_CDATA, length);
    }
}