from Crypto.Cipher import AES
from Crypto.Protocol.KDF import scrypt
from Crypto.Util.number import long_to_bytes

HexMyKey = "your_hex_key_here"
HexEncryptedOriginalMessage = "your_hex_encrypted_message_here"

key = bytes.fromhex(HexMyKey)
data = bytes.fromhex(HexEncryptedOriginalMessage)

nonce, ciphertext_and_tag = data[:16], data[16:]
cipher = AES.new(key, AES.MODE_GCM, nonce=nonce)
plaintext = cipher.decrypt_and_verify(ciphertext_and_tag[:-16], tag=ciphertext_and_tag[-16:])

print(plaintext.decode())