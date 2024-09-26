from Cryptodome.PublicKey import RSA
from Cryptodome import Random

def generate_keypair(bits=2048):
    random_generator = Random.new().read
    rsa_key = RSA.generate(bits, random_generator)
    print(repr(rsa_key))
    print(repr(rsa_key.publickey()))

if __name__ == "__main__":
    generate_keypair()