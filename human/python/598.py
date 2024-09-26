import base64

from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric.padding import PKCS1v15
from cryptography.hazmat.primitives.hashes import SHA256
from cryptography.hazmat.primitives.serialization import load_pem_private_key

def main():
    bk = default_backend()

    with open("./key.pem", "rb") as key_file:
        private_key = load_pem_private_key(key_file.read(), password=None, backend=bk)

    payload = b'foople'
    signature = base64.b64encode(private_key.sign(
        payload,
        padding=PKCS1v15(),
        algorithm=SHA256(),
    )).decode()

    print(signature)

if __name__ == "__main__":
    main()