import base64
from Crypto.Cipher import AES
from Crypto import Random

BS = 16
pad = lambda s: s + (BS - len(s) % BS) * chr(BS - len(s) % BS) 
unpad = lambda s : s[:-ord(s[len(s)-1:])]

class AESCipher:
    def __init__( self, key ):
        self.key = key

    def encrypt( self, raw, iv ):
        raw = pad(raw)
        cipher = AES.new( self.key, AES.MODE_CBC, iv )
        return base64.b64encode( cipher.encrypt( raw ) )

    def decrypt( self, enc, iv ):
        enc = base64.b64decode(enc)
        cipher = AES.new(self.key, AES.MODE_CBC, iv )
        return unpad(cipher.decrypt( enc ))

if __name__ == "__main__":
    key = 'fce4aa4dcf0d2b27fe4ffdafa602c81d1930c410f48ada5c763d4c4052a939eb'.decode('hex_codec')
    iv = 'c75271d593ca86ca785e3bb25e8d02cb'.decode('hex_codec')
    text = "This bloody encryption engine won't work !"

    a = AESCipher(key)
    encrypted_text = a.encrypt(text, iv)
    print("Encrypted text:", encrypted_text)

    b = AESCipher(key)
    decrypted_text = b.decrypt(encrypted_text, iv)
    print("Decrypted text:", decrypted_text)