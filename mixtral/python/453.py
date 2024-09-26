from Crypto.Protocol.KDF import HKDF
from Crypto.Random import get_random_bytes
from Crypto.Cipher import AES

def encrypt(message, password):
    salt = get_random_bytes(16)

    key = HKDF(password, length=32, salt=salt, info=None).derive()

    cipher = AES.new(key, mode=AES.MODE_GCM)

    encrypted_message, tag = cipher.encrypt_and_digest(bytes(message, 'utf-8'))

    return salt + cipher.nonce + tag + encrypted_message

def decrypt(ciphertext, password):
    salt = ciphertext[:16]
    nonce = ciphertext[16:32]
    tag = ciphertext[32:48]
    encrypted_message = ciphertext[48:]

    key = HKDF(password, length=32, salt=salt, info=None).derive()

    decryptor = AES.new(key, mode=AES.MODE_GCM, nonce=nonce)

    return decryptor.decrypt_and_verify(encrypted_message, tag)[0].decode('utf-8')

# Test the functions
password = "my_secret_password"
message = "Hello, World!"

ciphertext = encrypt(message, password)
print("Ciphertext:", ciphertext)

decrypted_message = decrypt(ciphertext, password)
print("Decrypted message:", decrypted_message)