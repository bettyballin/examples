import os
from Cryptodome.Random import get_random_bytes
from Cryptodome.Protocol.KDF import HKDF
from Cryptodome.PublicKey import ECC
from Cryptodome.Cipher import AES

# Generate a new key pair
private_key = ECC.generate(curve='P-256')
public_key = private_key.public_key()

def encrypt_data(plaintext, public_key):
    # Derive shared secret
    derived_secret = HKDF(
        password=private_key._raw_key,
        salt=get_random_bytes(16),
        hashmod=None
    ).derive(public_key._raw_key)

    key = derived_secret[:32]
    nonce = get_random_bytes(12)
    cipher = AES.new(key, AES.MODE_GCM, nonce=nonce)
    ciphertext, tag = cipher.encrypt_and_digest(plaintext)

    return (nonce + ciphertext + tag).hex()

def decrypt_data(ciphertext, private_key):
    # Derive shared secret
    ciphertext = bytes.fromhex(ciphertext)
    nonce = ciphertext[:12]
    ciphertext = ciphertext[12:-16]
    tag = ciphertext[-16:]

    derived_secret = HKDF(
        password=private_key._raw_key,
        salt=get_random_bytes(16),
        hashmod=None
    ).derive(private_key.public_key()._raw_key)

    key = derived_secret[:32]
    cipher = AES.new(key, AES.MODE_GCM, nonce=nonce)
    decrypted = cipher.decrypt_and_verify(ciphertext, tag)

    return decrypted

# Encryption
plaintext = b"Hello, World!"
encrypted_data = encrypt_data(plaintext, public_key)
print("Encrypted:", encrypted_data)

# Decryption
decrypted_data = decrypt_data(encrypted_data, private_key)
print("Decrypted:", decrypted_data.decode())