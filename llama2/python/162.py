from Crypto.Cipher import AES
from Crypto.Protocol.KDF import scrypt
from Crypto.Util.number import long_to_bytes

def decrypt_message(HexMykey, HexEncryptedOriginalMessage):
    key = bytes.fromhex(HexMykey)
    data = bytes.fromhex(HexEncryptedOriginalMessage)

    # Split the encrypted message into four parts
    nonce, ciphertext, mac_tag, padding = data[:12], data[12:32], data[32:48], data[48:]

    cipher = AES.new(key, AES.MODE_GCM, nonce=nonce)
    dec = cipher.decrypt_and_verify(ciphertext, mac_tag)

    # Remove the padding
    padding_len = len(padding)
    dec = dec[:-padding_len]

    return dec

# Usage
HexMykey = "your_hex_key_here"
HexEncryptedOriginalMessage = "your_hex_encrypted_message_here"
decrypted_message = decrypt_message(HexMykey, HexEncryptedOriginalMessage)
print(decrypted_message)