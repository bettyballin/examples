import ecdsa
from binascii import unhexlify

def decode_base64url(input):
    """Decode a Base64URL string."""
    input = input.replace("-", "+").replace("_", "/")
    padding_length = 3 - ((len(input) + 3) % 4)
    if padding_length < 3:
        input += "=" * padding_length
    return input.encode("ascii")

def compress_point(x, y):
    """Compress the point (x,y) to a compressed public key."""
    prefix = "03" if int.from_bytes(y[-1:], byteorder='big') % 2 == 0 else "02"
    return bytes([int(prefix[i:i+2], 16) for i in range(0, len(prefix), 2)]).hex() + x.hex()

def decompress_point(compressed_key):
    """Decompress the compressed public key to (x, y)."""
    decoded = unhexlify("0" + "".join([compressed_key[i:i+2] for i in range(1, len(compressed_key), 2)]))
    prefix = int.from_bytes(decoded[:-32], byteorder='big')
    curve = ecdsa.SECP256k1
    x = int.from_bytes(decoded[-32:], byteorder='big')
    y = curve.calculate_y(x, prefix)
    return x.to_bytes(32, byteorder='big'), y.to_bytes(32, byteorder='big')

# Example usage:
x = b'\x12\x34\x56\x78\x90\xab\xcd\xef\x01\x23\x45\x67\x89\x0a\xbc\xde\xf0\x12\x34\x56\x78\x90\xab\xcd\xef\x01\x23\x45\x67\x89\x0a'
y = b'\x98\x76\x54\x32\x10\xef\xcd\xab\x90\x78\x56\x34\x12\x0a\xbc\xde\xf0\x12\x34\x56\x78\x90\xab\xcd\xef\x01\x23\x45\x67\x89\x0a'
compressed_key = compress_point(x, y)
print(compressed_key)
decompressed_x, decompressed_y = decompress_point(compressed_key)
print(decompressed_x.hex())
print(decompressed_y.hex())