import base64
import chacha20poly1305

key = base64.b64decode('MDEyMzQ1Njc4OTAxMjM0NTAxMjM0NTY3ODkwMTIzNDU=')
nonce = base64.b64decode('MDEyMzQ1Njc4OTAx')
data = base64.b64decode('4bAaXOlQGhLI3tAsJju0e8Z737eF683Izik+6Uz4axPKj6NbmGLXcCgxukIyo8whOsu2lEgg3llInLA=')

auth_tag_length = 16
encrypted = data[:-auth_tag_length]
tag = data[-auth_tag_length:]

decipher = chacha20poly1305.ChaCha20Poly1305(key, nonce)
try:
    decrypted = decipher.decrypt(encrypted + tag).decode('utf-8')
    print(decrypted)
except:
    print("Decryption failed!")