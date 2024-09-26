from Crypto.Cipher import AES

HexMyKey = '6f9b706748f616fb0cf39d274638ee29813dbad675dd3d976e80bde4ccd7546a'
HexEncryptedOriginalMessage = '6b855acc799213c987a0e3fc4ddfb7719c9b87fcf0a0d35e2e781609143b6e2d8e743cf4aea728002a9fc77ef834'

key = bytes.fromhex(HexMyKey)
data = bytes.fromhex(HexEncryptedOriginalMessage)

cipher = AES.new(key, AES.MODE_GCM, data[:16])  # nonce
try:
    dec = cipher.decrypt_and_verify(data[16:-16], data[-16:])  # ciphertext, tag
    print(dec.decode('utf-8'))  # my secret data
except ValueError:
    print("Decryption failed")