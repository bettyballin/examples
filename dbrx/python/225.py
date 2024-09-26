from Crypto.Signature import pkcs1_15
from Crypto.Hash import SHA256
from Crypto.PublicKey import RSA
import wincertstore

def main():
    # Load the certificate (with associated private key) from store using wincertstore library
    cert = next(wincertstore.CertSystemStore("MY").iter_certificates())

    # Extract public and private keys from cert object
    public_key = RSA.importKey(cert.get_public_key())
    private_key = RSA.importKey(cert.get_private_key())

    # Create a message to sign
    message = b"This is the data I want to sign"

    # Hashing algorithm (SHA-256 in this case)
    hash_obj = SHA256.new(message)

    # Sign the hash using private key
    signature = pkcs1_15.new(private_key).sign(hash_obj)

    print("Signature:", signature)

if __name__ == "__main__":
    main()