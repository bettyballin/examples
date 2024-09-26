import javacard.framework.*;

public class Temp1427 extends Applet {
    private RSAPublicKey m_publicKey;

    protected Temp1427() {
        // Initialize m_publicKey with a valid RSAPublicKey instance
        // This is just a placeholder for initialization
        m_publicKey = (RSAPublicKey) KeyBuilder.buildKey(KeyBuilder.TYPE_RSA_PUBLIC, KeyBuilder.LENGTH_RSA_2048, false);
        register();
    }

    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new Temp1427();
    }

    public void process(APDU apdu) {
        if (selectingApplet()) {
            return;
        }
        byte[] buffer = apdu.getBuffer();
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
        short length = m_publicKey.getExponent(buffer, (short) 0);
        apdu.setOutgoingAndSend((short) 0, length);
    }

    private void getModulus(APDU apdu) {
        byte[] buffer = apdu.getBuffer();
        short length = m_publicKey.getModulus(buffer, (short) 0);
        apdu.setOutgoingAndSend((short) 0, length);
    }
}