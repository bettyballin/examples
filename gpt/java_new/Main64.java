import org.bitcoinj.crypto.*;
import org.bitcoinj.wallet.*;

public class Main64 {
    public static void main(String[] args) throws Exception {
        String seedCode = "yard impulse luxury drive today throw farm pepper survey wreck glass federal";

        // BitcoinJ
        DeterministicSeed seed = new DeterministicSeed(seedCode, null, "", 1409478661L);
        DeterministicKeyChain chain = DeterministicKeyChain.builder().seed(seed).build();
        
        // The BIP32 root key can be retrieved from the chain.
        DeterministicKey rootKey = chain.getRootKey();
        
        // Your code for using the rootKey goes here.
    }
}