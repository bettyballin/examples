from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad
import base64

def customEncode(ciphertextB64):
    return base64.b64decode(ciphertextB64)

ciphertextB64 = """amDDjAsQJjEzw7nFvSpcIgHFksO/xb3CoF7Cv+KAsMKN4oCZNeKAulxaHwghwo1ExaEQKcOrGMO9
                   Iw4Rw4sncsOLxb3Di8OKwqs0AgdFwo1CB8Oy4oCTPkrDlSbDkTDDtB3Cj2PDocW4AcKxM0bigJnD
                   gsOsw6scw47DlQHCuEEnwqxZwqnDp8KdDBNzw7JKw70aw5/DtcK2FHzigJNJwq1kBsKyw57CpMOi
                   CkPigJQnw5nCgVUcw5bCtl9j4oCcG8OGw5Yiw4zCv1bDrzhBMREIwr1yKMOTT8OMw68OVsOKeGxx
                   wq3Dv0Nkw4vDgcO4wqYCw7DDi8OEFsKjEcOjwrdzw5RUdU/CqwBZw6rDvcKsw67DvE5lwqvDhMKv
                   w5HDiwBy4oC6NsO+w5vigLDDjcOGMHElHA7CjULDnsKtUuKAoH0LUxclPV3FuMO6aWtVAuKAnlcF
                   wr/CsDbCqQEAwr1JMcW+w692w6XCrgbDt8ObZDnDgcOqF8KmwrrCucK9a8Kt4oCdZMOpHiPDigfD
                   hcWSNMOmw7zDhcOPAMOlSzXDs2XDlMKoBcOLdcOMw5PDjeKAusKxw7U94oCgY8Oww6XDrnLigJQj
                   csO7wq8vy5wJMcK4cuKAoMO/MsO/4oCwJcOdXMK0fWxND8uGbiRnBMW4Kw=="""

cipherbytes = customEncode(ciphertextB64)
key = b'\x12\x34\x56\x78\x9A\xBC\xDE\xF0\x12\x34\x56\x78\x9A\xBC\xDE\xF0\x12\x34\x56\x78\x9A\xBC\xDE\xF0\x12\x34\x56\x78\x9A\xBC\xDE\xF0'
iv1 = b'\x02\x13\x24\x35\x46\x57\x68\x79\x8A\x9B\xAC\xBD\xCE\xDF\xE0\xF1'
cipher = AES.new(key, AES.MODE_CBC, iv1)
decrypted = cipher.decrypt(cipherbytes)
decryptedUnpad = unpad(decrypted, AES.block_size)
print(decryptedUnpad)