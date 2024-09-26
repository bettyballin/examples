from Crypto.Cipher import AES
import base64

key = b'mykey123456789012345678901234'
encrypted_text = 'your_encrypted_text_here=='  # replace with your encrypted text

# The length of an aes256 key is 32 bytes (256 bits)
if len(key) != 16 and len(key) != 24 and len(key) != 32:
    raise ValueError("Invalid AES key size")

cipher = AES.new(key, AES.MODE_ECB)

decrypted_text = cipher.decrypt(base64.b64decode(encrypted_text))

print(decrypted_text.decode('utf-8'))