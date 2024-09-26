from cryptography.hazmat.primitives.serialization import load_pem_public_key
from cryptography.hazmat.backends import default_backend

def load_key(pem_key):
    return load_pem_public_key(pem_key, backend=default_backend())

if __name__ == "__main__":
    pem_key = b"""-----BEGIN PUBLIC KEY-----
    YOUR_PEM_KEY_HERE
    -----END PUBLIC KEY-----
    """
    key = load_key(pem_key)
    print(key)