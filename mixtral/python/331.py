from Crypto.Cipher import ChaCha20
from Crypto.Hash import Poly1305

class ChaCha20Poly1305:
    def __init__(self, locking, key, nonce):
        self._locking = locking

        # Derive separate nonces for each primitive
        chacha_nonce = nonce[:16]
        poly_nonce  = nonce[16:32]

        cipher = ChaCha20.new(key=key, nonce=chacha_nonce)

        if locking:
            self._cipher = cipher.encryptor()
        else:
            self._cipher = cipher.decryptor()

        # Use separate nonces for Poly1305
        self._auth = Poly1305.new(key=key)

        if locking:
            self._auth.update(poly_nonce + b'\x00\x00\x00\x01')
        else:
            # For decryption use the same nonces as in encryption
            self._auth = Poly1305.new(key=key)

    def update(self, data):
        ctxt = self._cipher.update(data)

        if self._locking:
            self._auth.update(ctxt)

        return ctxt

# Example usage:
key = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15\x16\x17\x18\x19\x20\x21\x22\x23\x24\x25\x26\x27\x28\x29\x30\x31'
nonce = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15\x16\x17\x18\x19\x20\x21\x22\x23\x24\x25\x26\x27\x28\x29\x30\x31'
locking = True

cipher = ChaCha20Poly1305(locking, key, nonce)
ciphertext = cipher.update(b'Hello, World!')