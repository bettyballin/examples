import os
from Cryptodome.PublicKey import RSA
from Cryptodome import Random

def generate_keypair(bits=2048):
    random_generator = Random.new().read
    rsa_key = RSA.generate(bits, random_generator)
    return rsa_key.exportKey(), rsa_key.publickey().exportKey()

if __name__ == "__main__":
    private_key, public_key = generate_keypair()
    with open("private_key.pem", "wb") as f:
        f.write(private_key)
    with open("public_key.pem", "wb") as f:
        f.write(public_key)
    print("Key pair generated. Private key saved to private_key.pem, public key saved to public_key.pem.")