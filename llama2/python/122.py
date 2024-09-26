import bip39
from bip39 import mnemonic
from bip39utils import Bip39SeedGenerator, Bip39WordsGenerator
from bitcoinutils.setup import setup
from bitcoinutils.keys import PrivateKey, PublicKey
from bitcoinutils.transactions import Transaction, TxInput, TxOutput
from bitcoinutils.script import Script

setup('mainnet')

def generate_keypair(coin, entropy):
    if coin == 'btc':
        seed = bip39.mnemonic_to_seed(entropy)
        seed_root = bip39.SeedGenerator(seed).generate()
        private_key = PrivateKey.from_wif(seed_root)
        public_key = private_key.get_public_key()
        address = public_key.get_address()
        return {'public': {'address': address}, 'private': private_key.to_wif()}

# Generate a mnemonic code
words = bip39.generate_mnemonic(24)

# Convert the user-provided entropy to a seed
entropy = bip39.mnemonic_to_seed(words, passphrase='apassphrase')

# Generate a public/private key pair
address = generate_keypair('btc', words)

print(words)  
print(entropy)
print(address['public']['address'])