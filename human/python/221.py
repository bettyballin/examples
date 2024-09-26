from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

def Enc_OAEP(m, e, n):
    key = serialization.load_pem_public_key(
        e,
        backend=default_backend()
    )
    encrypted = key.encrypt(
        m,
        padding.OAEP(
            mgf=padding.MGF1(algorithm=hashes.SHA256()),
            algorithm=hashes.SHA256(),
            label=None
        )
    )
    return encrypted

def Sign_PSS(hash_c, d, n):
    key = serialization.load_pem_private_key(
        d,
        password=None,
        backend=default_backend()
    )
    signature = key.sign(
        hash_c,
        padding.PSS(
            mgf=padding.MGF1(algorithm=hashes.SHA256()),
            salt_length=padding.PSS.MAX_LENGTH
        ),
        hashes.SHA256()
    )
    return signature

# usage
m = b"message"
e = b"-----BEGIN PUBLIC KEY-----...-----END PUBLIC KEY-----"
n = 2048
c = Enc_OAEP(m, e, n)

hash_c = hashes.Hash(hashes.SHA256(), default_backend())
hash_c.update(c)
hash_c = hash_c.finalize()

d = b"-----BEGIN PRIVATE KEY-----...-----END PRIVATE KEY-----"
s = Sign_PSS(hash_c, d, n)