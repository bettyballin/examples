
from Crypto.Cipher import AES
from Crypto.Protocol.KDF import EVP_BytesToKey
from base64 import b64decode, b64encode
import hashlib

# The passphrase used for encryption
passphrase = 'qwerty012
