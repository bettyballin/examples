from Crypto.Cipher import PKCS1_OAEP, AES
from base64 import b64decode

# Assuming 'key' is an RSA private key object, 'encrypted_key' is a base64-encoded encrypted key,
# 'ciphertext' is the encrypted data, and 'tag' is the authentication tag.

key = PKCS1_OAEP.new(RSA.import_key(open('private.pem').read()))

with open('encrypted_key.txt', 'r') as f:
    encrypted_key = f.read()

with open('ciphertext.txt', 'rb') as f:
    ciphertext = f.read()

with open('tag.txt', 'rb') as f:
    tag = f.read()

# Decrypt the secret key using RSA private key.
decrypted_key = key.decrypt(b64decode(encrypted_key))

# Now use this decrypted symmetric key for decryption of actual data.
cipher_aes = AES.new(decrypted_key, AES.MODE_EAX)
plaintext = cipher_aes.decrypt_and_verify(ciphertext, tag)

print("Decrypted text: ", plaintext.decode())