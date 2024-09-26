import hashlib
import rsa

# Generate a new RSA key pair
(public_key, private_key) = rsa.newkeys(512)

# Create a signature object
sign = rsa.Signature(hashlib.sha1(b'message').digest(), 'SHA-1')

print(sign._name)
print("sha1WithRSAEncryption")