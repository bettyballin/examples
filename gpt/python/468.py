
import base64

def base64url_to_bytes(base64url_string):
    padding = '=' * (4 - (len(base64url_string) % 4))
    base64_string = base64url_string.replace('-', '+').replace('_', '/') + padding
    return base64.b64decode(base64_string)

def compress_point(x, y):
    """Compresses the point (x, y) to a 33-byte compressed public key."""
    prefix = '02' if y % 2 == 0 else '03'
    return prefix + x.to_bytes(32, byteorder='big').hex()

def decompress_point(curve, compressed_key):
    """Decompresses the compressed public key to (x, y)."""
    prefix = compressed_key[:2]
    x_bytes = bytes.fromhex(compressed_key[2:])
    x = int.from_bytes(x_bytes, 'big')
    # Recover
