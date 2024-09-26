import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;

/*
 * This program executes the Diffie-Hellman key agreement protocol between
 * 5 parties: Alice, Bob, Carol, Sara and Dave using a shared 2048-bit DH parameter.
 */
public class DHKeyAgreement5 {
    private DHKeyAgreement5() {}

    public static void main(String argv[]) throws Exception {

        // Alice creates her own DH key pair with 2048-bit key size
        KeyPairGenerator aliceKpairGen = KeyPairGenerator.getInstance("DH");
        aliceKpairGen.initialize(2048);
        KeyPair aliceKpair = aliceKpairGen.generateKeyPair();
        // This DH parameters can also be constructed by creating a
        // DHParameterSpec object using agreed-upon values
        DHParameterSpec dhParamShared = ((DHPublicKey)aliceKpair.getPublic()).getParams();
        // Bob creates his own DH key pair using the same params
        KeyPairGenerator bobKpairGen = KeyPairGenerator.getInstance("DH");
        bobKpairGen.initialize(dhParamShared);
        KeyPair bobKpair = bobKpairGen.generateKeyPair();
        // Carol creates her own DH key pair using the same params
        KeyPairGenerator carolKpairGen = KeyPairGenerator.getInstance("DH");
        carolKpairGen.initialize(dhParamShared);
        KeyPair carolKpair = carolKpairGen.generateKeyPair();
        // Sara creates her own DH key pair using the same params
        KeyPairGenerator saraKpairGen = KeyPairGenerator.getInstance("DH");
        saraKpairGen.initialize(dhParamShared);
        KeyPair saraKpair = saraKpairGen.generateKeyPair();
        // Dave creates her own DH key pair using the same params
        KeyPairGenerator daveKpairGen = KeyPairGenerator.getInstance("DH");
        daveKpairGen.initialize(dhParamShared);
        KeyPair daveKpair = daveKpairGen.generateKeyPair();

        // Alice initialize
        KeyAgreement aliceKeyAgree = KeyAgreement.getInstance("DH");
        // Alice computes gA
        aliceKeyAgree.init(aliceKpair.getPrivate());

        // Bob initialize
        KeyAgreement bobKeyAgree = KeyAgreement.getInstance("DH");
        // Bob computes gB
        bobKeyAgree.init(bobKpair.getPrivate());

        // Carol initialize
        KeyAgreement carolKeyAgree = KeyAgreement.getInstance("DH");
        // Carol computes gC
        carolKeyAgree.init(carolKpair.getPrivate());

        // Sara initialize
        KeyAgreement saraKeyAgree = KeyAgreement.getInstance("DH");
        // Sara computes gS
        saraKeyAgree.init(saraKpair.getPrivate());

        // Dave initialize
        KeyAgreement daveKeyAgree = KeyAgreement.getInstance("DH");
        // Dave computes gD
        daveKeyAgree.init(daveKpair.getPrivate());

        // First Pass

        // Alice computes gDA
        Key gDA = aliceKeyAgree.doPhase(daveKpair.getPublic(), false);

        // Bob computes gAB
        Key gAB = bobKeyAgree.doPhase(aliceKpair.getPublic(), false);

        // Carol computes gBC
        Key gBC = carolKeyAgree.doPhase(bobKpair.getPublic(), false);

        // Sara computes gCS
        Key gCS = saraKeyAgree.doPhase(carolKpair.getPublic(), false);

        // Dave computes gSD
        Key gSD = daveKeyAgree.doPhase(saraKpair.getPublic(), false);

        // Second Pass

        // Alice computes gSDA
        Key gSDA = aliceKeyAgree.doPhase(gSD, false);

        // Bob computes gDAB
        Key gDAB = bobKeyAgree.doPhase(gDA, false);

        // Carol computes gABC
        Key gABC = carolKeyAgree.doPhase(gAB, false);

        // Sara computes gBCS
        Key gBCS = saraKeyAgree.doPhase(gBC, false);

        // Dave computes gCSD
        Key gCSD = daveKeyAgree.doPhase(gCS, false);

        // Third Pass

        // Alice computes gCSDA
        Key gCSDA = aliceKeyAgree.doPhase(gCSD, false);

        // Bob computes gSDAB
        Key gSDAB = bobKeyAgree.doPhase(gSDA, false);

        // Carol computes gDABC
        Key gDABC = carolKeyAgree.doPhase(gDAB, false);

        // Sara Computes gABCS
        Key gABCS = saraKeyAgree.doPhase(gABC, false);

        // Dave