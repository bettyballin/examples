from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad
import base64

test_enc = "bLdmGA+HLLyFEVtBEuCzVg=="
enc = base64.b64decode(test_enc)
derived_key = base64.b64decode("LefjQ2pEXmiy/nNZvEJ43i8hJuaAnzbA1Cbn1hOuAgA=")
iv = "1020304050607080"
cipher = AES.new(derived_key, AES.MODE_CBC, iv.encode('utf-8'))
print(unpad(cipher.decrypt(enc),16).decode('utf-8')) # hello