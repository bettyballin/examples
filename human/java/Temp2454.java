import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.DeterministicKeyChain;
import org.bitcoinj.crypto.DeterministicSeed;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.DeterministicKeyChain;
import org.bitcoinj.wallet.DeterministicKey;
import org.bitcoinj.wallet.HDUtils;
import org.web3j.crypto.Credentials;

import java.math.BigInteger;
import java.util.List;

public class Temp2454 {
    public static void main(String[] args) {
        String seedCode = "yard impulse luxury drive today throw farm pepper survey wreck glass federal";

        // BitcoinJ
        DeterministicSeed seed = new DeterministicSeed(seedCode, null, "", 1409478661L);
        DeterministicKeyChain chain = DeterministicKeyChain.builder().seed(seed).build();
        List<ChildNumber> keyPath = HDUtils.parsePath("M/44H/60H/0H/0/0");
        DeterministicKey key = chain.getKeyByPath(keyPath, true);
        BigInteger privKey = key.getPrivKey();

        // Web3j
        Credentials credentials = Credentials.create(privKey.toString(16));
        System.out.println(credentials.getAddress());
    }
}