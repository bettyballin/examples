
from cryptography.hazmat.primitives import serialization

# ... your existing code to generate self.cert and self.private_key

def write_key_and_cert(self, certname="cert.pem", keyname="key.pem"):
    with open(certname, "wb") as f:
        f.write(self.cert.public_bytes(serialization.Encoding.PEM))
    with open(keyname, "wb") as f:
        f.write(self.private_key.private_bytes(
            encoding=serialization.Encoding.PEM,
            format=serialization.PrivateFormat.TraditionalOpenSSL,
            encryption_algorithm=serialization.NoEncryption()  # No passphrase
        ))

