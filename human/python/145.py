from os import urandom as _urandom
from binascii import hexlify as _hexlify

if __name__ == "__main__":
    random_bytes = _urandom(16)
    hex_string = _hexlify(random_bytes)
    print(hex_string.decode('utf-8'))