from Crypto.Cipher import AES

HexMyKey = "your_hex_key_here"
HexEncryptedOriginalMessage = "your_hex_encrypted_message_here"

key = bytes.fromhex(HexMyKey)
data = bytes.fromhex(HexEncryptedOriginalMessage)
nonce_size = 12
tag_size = 16

# Split the data into nonce ciphertext and tag
nonce = data[:nonce_size]
ciphertext = data[nonce_size:-tag_size]
tag = data[-tag_size:]

cipher = AES.new(key, AES.MODE_GCM, nonce=nonce)
decrypted_data = cipher.decrypt_and_verify(ciphertext, tag)

print(decrypted_data)