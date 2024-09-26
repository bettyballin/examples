from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_v1_5

def main():
    handshake = "9601aa2a2768b58af647e03f23e3bdaa5d9ab12d648d85755aaaee430ea273946dec5348aaa61dc261138d50d2c80966b7113a659ad5a3998263e2dc0ce4bba5dbd22d2c6bc5c4c75802b8b130d1b0b39558d5516bbe1a1ce2852a6495e52fda5259626480ec1aede49a085b5f6005a1317cfabf72ff740cd038808e01fb3ac2".decode('hex')

    with open('server.key', 'r') as f:
        privkey = f.read()
    rsakey = RSA.importKey(privkey)
    rsa = PKCS1_v1_5.new(rsakey)
    sentinel = 'Failure'
    decrypted = rsa.decrypt(handshake, sentinel)

    print decrypted.encode('hex')

if __name__ == "__main__":
    main()