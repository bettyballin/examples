#!/usr/bin/env python3

from hashlib import sha256

def main():
    msg = 'The quick brown fox jumps over the lazy dog'
    key = 'key'

    block_size_bytes = 64

    block_opad_bytes = b'\x5c' * block_size_bytes
    block_ipad_bytes = b'\x36' * block_size_bytes
    key_bytes = key.encode().ljust(block_size_bytes, b'\0')

    si_bytes = bytes([a ^ b for (a, b) in zip(block_ipad_bytes, key_bytes)]) 
    so_bytes = bytes([a ^ b for (a, b) in zip(block_opad_bytes, key_bytes)]) 

    a = sha256(so_bytes + sha256(si_bytes + msg.encode()).digest())

    print(a.digest().hex()) # f7bc83f430538424b13298e6aa6fb143ef4d59a14946175997479dbc2d1a3cd8

if __name__ == "__main__":
    main()