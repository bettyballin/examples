import hashlib

def calculate_ikm(ikm, block_size):
    if len(ikm) > block_size:
        ikm = hashlib.sha256(ikm).digest()
    return bytes([b ^ 0x36 for b in ikm]) + (block_size - len(ikm)) * b'\x00'

def calculate_okm(okm, block_size):
    if len(okm) > block_size:
        okm = hashlib.sha256(okm).digest()
    return bytes([b ^ 0x5c for b in okm]) + (block_size - len(okm)) * b'\x00'