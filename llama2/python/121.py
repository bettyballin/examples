import bip39
from bip39 import mnemo
from bip32utils import BIP32Key

# Generate a mnemonic code
words = bip39.generate_mnemonic(24)

# Convert the mnemonic code to a seed
entropy = bip39.mnemo.to_seed(words, passphrase='apassphrase')

# Generate a public/private key pair
key = BIP32Key.fromEntropy(entropy)
address = {
    'public': {
        'address': key.Address()
    },
    'private': {
        'hex': key.PrivateKey().hex()
    }
}

print(words)  
print(entropy.hex())
print(address['public']['address'])
print(address['private']['hex'])