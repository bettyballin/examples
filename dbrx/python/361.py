import ecdsa
import binascii
import base64

def base64url_to_bytes(base64url_string):
    padding  = '=' * (4 - len(base64url_string) % 4)
    return base64.urlsafe_b64decode(base64url_string + padding)

def compress_point(x, y):
    """Compresses the point (x, y) to a 33-byte compressed public key."""
    prefix = "02" if int(y.hex(), 16) % 2 == 0 else "03"
    return bytes.fromhex(prefix + x.hex())

def decompress_point(compressed_key):
    """Decompresses the compressed public key to (x, y)."""
    curve = ecdsa.SECP256k1.curve
    prefix = int(compressed_key[:1].hex(), 16)
    point_x = int.from_bytes(compressed_key[1:], byteorder='big')
    return curve.point(point_x, None) if prefix == 0x02 else curve.point(None, -point_x)

def get_public_key(x_value: bytes, y_value: bytes):
    x, y = ecdsa.util.order_from_int(int.from_bytes(x_value, 'big')), int.from_bytes(y_value, byteorder='big')
    compressed_key = compress_point(x, y)
    decompressed_x, _ = decompress_point(compressed_key)
    return f"{decompressed_x.x():x}"

if __name__ == "__main__":
    x_base64url = "ARriqkpHlC1Ia1Tk86EM_bqH_9a88Oh2zMYF3fUUGJw"
    y_base64url = "wTYd3CEiwTk1n-lFPdpZ51P4Z0EzlVNXLvJMY-k55pQ"

    x_value = base64url_to_bytes(x_base64url)
    y_value = base64url_to_bytes(y_base64url)

    public_key_hex = get_public_key(x_value, y_value)
    print(f"Public key (hex): {public_key_hex}")