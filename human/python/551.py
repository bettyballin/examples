from Crypto.Cipher import AES

tink_ciphertext = bytes.fromhex('0000000000000000000000000000000000000000000000000000000000000000')  # replace with your ciphertext
key = bytes.fromhex('000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f')

prefix = tink_ciphertext[:5]
nonce = tink_ciphertext[5:5 + 12]
ciphertext = tink_ciphertext[5 + 12:-16]
tag = tink_ciphertext[-16:]

cipher = AES.new(key, AES.MODE_GCM, nonce=nonce)
cipher.update(b'')
decryptedText = cipher.decrypt_and_verify(ciphertext, tag)

print(decryptedText.decode('utf-8'))