from base64 import b64encode, b64decode
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad

def encrypt(data, key, iv):
    cipher = AES.new(key, AES.MODE_CBC, iv)
    padded_data = pad(data.encode(), AES.block_size)
    return b64encode(cipher.encrypt(padded_data)).decode()

def decrypt(encrypted_data, key, iv):
    cipher = AES.new(key, AES.MODE_CBC, iv)
    padded_decrypted_bytes = cipher.decrypt(b64decode(encrypted_data))
    return unpad(padded_decrypted_bytes, AES.block_size).decode()

# Example usage:

key = bytes.fromhex('fce4aa4dcf0d2b27fe4ffdafa602c81d1930c410f48ada5c763d4c4052a939eb')
iv  = bytes.fromhex('c75271d593ca86ca785e3bb25e8d02cb')

data_to_encrypt = "This bloody encryption engine won't work !"

# Encryption
encrypted_data = encrypt(data_to_encrypt, key, iv)
print("Encrypted data:", encrypted_data)

# Decryption
decrypted_data = decrypt(encrypted_data, key, iv)
print("Decrypted data:", decrypted_data)