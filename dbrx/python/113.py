from base64 import b64decode, b64encode
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad

# Key & IV from your question (hex encoded)
key = bytes.fromhex('fce4aa4dcf0d2b27fe4ffdafa602c81d1930c410f48ada5c763d4c4052a939eb')
iv = bytes.fromhex('c75271d593ca86ca785e3bb25e8d02cb')

# Clear data from your question
clear_data = b'This bloody encryption engine won\'t work !'

# Encrypt clear data with AES-256-CBC-PKCS5Padding using PyCryptoDome library
cipher = AES.new(key, AES.MODE_CBC, iv)
encrypted_data = cipher.encrypt(pad(clear_data, AES.block_size))

print("Encrypted Data (Base64):", b64encode(encrypted_data).decode())

# Decrypt encrypted data with the same key & IV used for encryption
decipher = AES.new(key, AES.MODE_CBC, iv)
encrypted_data = b64decode('44FsQIcqM412+YXZBwwoQSCz2uB9QPQMXJ410Xpw1f/M5RTRS7N6yfziAGq/Fd/E')
clear_text = unpad(decipher.decrypt(encrypted_data), AES.block_size)

print("Clear Text:", clear_text.decode())