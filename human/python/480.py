import os
from cryptography.hazmat.primitives.ciphers.aead import AESCCM
from cryptography.hazmat.primitives import hashes

def print_ciphertext_tag(plaintext, key, iv, tag_length):
    ccm = AESCCM(key, tag_length=tag_length)
    encrypted = ccm.encrypt(iv, plaintext, None)
    tag = encrypted[-tag_length:]
    ciphertext = encrypted[:-tag_length]
    print(f"tag size: {tag_length}, IV size: {len(iv)}, IV (hex): {iv.hex():<24}, ciphertext (hex): {ciphertext.hex()}, tag (hex): {tag.hex()}")

plaintext = b'message from python'
key = bytes.fromhex('01234567890123456789012345678901')
nonce12 = os.urandom(12)
nonce7 = nonce12[:7]

print_ciphertext_tag(plaintext, key, iv=nonce12, tag_length=8)
print_ciphertext_tag(plaintext, key, iv=nonce7, tag_length=8)

print_ciphertext_tag(plaintext, key, iv=nonce12, tag_length=16)
print_ciphertext_tag(plaintext, key, iv=nonce7, tag_length=16)