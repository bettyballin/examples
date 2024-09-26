import base64
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.backends import default_backend

def rsa_encrypt(data, pub_keyObj):
    encrypted = pub_keyObj.encrypt(data, padding.OAEP(
        mgf=padding.MGF1(algorithm=hashes.SHA256()),
        algorithm=hashes.SHA256(),
        label=None
    ))
    return encrypted

def rsa_encrypt_base64(data, pub_keyObj):
    return base64.standard_b64encode(rsa_encrypt(data, pub_keyObj))

if __name__ == "__main__":
    private_key = rsa.generate_private_key(
        public_exponent=65537,
        key_size=2048,
        backend=default_backend()
    )
    public_key = private_key.public_key()

    pub_keyObj = public_key

    data = b"Hello, World!"
    print(rsa_encrypt_base64(data, pub_keyObj))