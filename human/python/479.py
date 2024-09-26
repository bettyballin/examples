import base64
from cryptography.hazmat.primitives.ciphers.aead import AESCCM

# Data from PHP code
key_from_php = base64.b64decode('<Base64 encoded key from PHP>')
ciphertext_from_php = base64.b64decode('<Base64 encoded (ciphertext + tag) from PHP>')
nonce_from_php = base64.b64decode('<Base64 encoded nonce from PHP>')

# Separate ciphertext and tag
tag_length = 8
ciphertext = ciphertext_from_php[:-tag_length]
tag = ciphertext_from_php[-tag_length:]

# Decrypt
cipher = AESCCM(key_from_php)
decrypted_message_from_php = cipher.decrypt(nonce_from_php, ciphertext, tag)
print(decrypted_message_from_php.decode())