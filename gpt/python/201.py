
from base64 import b64decode
from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad

# Your provided key and IV
key_hex = "fce4aa4dcf0d2b27fe4ffdafa602c81d1930c410f48ada5c763d4c4052a939eb"
iv_hex = "c75271d593ca86ca785e3bb25e8d02cb"

# Base64-encoded encrypted data
encrypted_data_b64 = "44FsQIcqM412+YXZBwwoQSCz2uB9QPQMXJ410Xpw1f/M5RTRS7N6yfziAGq/Fd/E"

# Convert key, IV from hex and encrypted data from Base64 to bytes
key = bytes.fromhex(key_hex)
iv = bytes.fromhex(iv_hex)
encrypted_data =
