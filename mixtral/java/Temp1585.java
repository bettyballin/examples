import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Hash;
import org.web3j.crypto.MnemonicUtils;
import org.web3j.utils.Numeric;

public class Temp1585 {
    public static void main(String[] args) {
        String seedCode = "yard impulse luxury drive today throw farm pepper survey wreck glass federal";
        byte[] seedBytes = MnemonicUtils.generateSeed(seedCode, "");
        ECKeyPair eckeyPair = ECKeyPair.create(Hash.sha3(seedBytes));
        Credentials credentials = Credentials.create(eckeyPair);
        System.out.println("Address: " + credentials.getAddress());
    }
}