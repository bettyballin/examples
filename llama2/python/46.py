from Crypto.Cipher import AES

# Create a little-endian AES object
aes_le = AES.new(bytes.fromhex('26333B482869778C14A2BEC1D4E2FD14'), AES.MODE_ECB)

# Encrypt data in Python
data = bytes.fromhex('b4364ee66c808b3b0f24070879a3b224')
ciphertext = aes_le.encrypt(data)

print(ciphertext.hex())