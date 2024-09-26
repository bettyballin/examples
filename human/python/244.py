from Crypto.Cipher import PKCS1_OAEP
from Crypto.PublicKey import RSA

def encode_rsa(message, key_path):    
    key = RSA.importKey(open(key_path).read())
    cipher = PKCS1_OAEP.new(key)
    ciphertext = cipher.encrypt(message.encode())
    return ciphertext.hex()

def decode_rsa(ciphertext, key_path):
    key = RSA.importKey(open(key_path).read())
    cipher = PKCS1_OAEP.new(key)
    message = cipher.decrypt(bytearray.fromhex(ciphertext))
    return message.decode()

# Example usage
public_key_path = "path_to_public_key.pem"
private_key_path = "path_to_private_key.pem"

message = "Hello, World!"
encoded_message = encode_rsa(message, public_key_path)
print("Encoded message:", encoded_message)

decoded_message = decode_rsa(encoded_message, private_key_path)
print("Decoded message:", decoded_message)