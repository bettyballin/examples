from base64 import b64decode
from Crypto.Cipher import AES

def pkcs7_padding(data):
    block_size = 16
    padding_len = block_size - len(data) % block_size
    return data + bytes([padding_len] * padding_len)

encrypted_text = b'your-hexadecimal-encoded-cipher'
key = 'mykey'.encode('utf8')
iv = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'  # Added IV

# Convert the hex encoded cipher to base64
b64_cipher = bytes.fromhex(encrypted_text.decode("utf-8"))

# Create a new AES CBC decryption object
decryptor = AES.new(key, mode=AES.MODE_CBC, IV=iv)  # Added IV

# Decode the Base64 cipher and remove padding
padded_plaintext = decryptor.decrypt(b64_cipher)

# Remove PKCS7 Padding
unpadder = lambda s: s[:-s[-1]]
original_message = unpadder(padded_plaintext)

print("Decrypted message:", original_message.decode('utf8'))