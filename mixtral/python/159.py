from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

privkeystr = "your_private_key_string_here"  # replace with your private key string
private_key = RSA.importKey(privkeystr)
privcipher = PKCS1_OAEP.new(private_key)