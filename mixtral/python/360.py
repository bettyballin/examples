import base64
from cryptography.fernet import Fernet

# Assuming 'encrypteduser' and 'encryptedpassword' are defined
encrypteduser = b'your_encrypted_user'
encryptedpassword = b'your_encrypted_password'
f = Fernet(b'your_fernet_key')

decrypteduser = f.decrypt(base64.urlsafe_b64decode(encrypteduser))
decryptedpassword = f.decrypt(base64.urlsafe_b64decode(encryptedpassword))

# Decode the bytes to string
originalusername = decrypteduser.decode()
originalpassword = decryptedpassword.decode()

print(originalusername)
print(originalpassword)