
from M2Crypto import RSA, EVP, X509

# Load recipient's public key and sender's private key
recipient_public_key = RSA.load_pub_key('recipient_public_key.pem')
