from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec

def generate_keys():
    private_key = ec.generate_private_key(ec.SECP256R1(), default_backend())
    public_key = private_key.public_key()
    # serializing into PEM
    rsa_pem = public_key.public_bytes(encoding=serialization.Encoding.PEM, format=serialization.PublicFormat.SubjectPublicKeyInfo)
    return private_key, public_key, rsa_pem

if __name__ == "__main__":
    private_key, public_key, rsa_pem = generate_keys()
    print("Private Key: ", private_key)
    print("Public Key: ", public_key)
    print("PEM Format: ", rsa_pem.decode('utf-8'))