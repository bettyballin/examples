from Crypto.PublicKey import RSA

def generate_rsa_keypair():
    key = RSA.generate(2048)
    public = key.publickey()
    return key, public

if __name__ == "__main__":
    private_key, public_key = generate_rsa_keypair()
    print(private_key.exportKey('PEM').decode('utf-8'))
    print(public_key.exportKey('PEM').decode('utf-8'))