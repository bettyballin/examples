import base64
from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

def rsa_encrypt(data):
    key = RSA.generate(2048)
    cipher = PKCS1_OAEP.new(key)
    return cipher.encrypt(data.encode()), key

def main():
    data = "Hello, World!"
    print(base64.standard_b64encode(rsa_encrypt(data)[0]))

if __name__ == "__main__":
    main()