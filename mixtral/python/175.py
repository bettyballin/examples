def pkcs7_pad(data):
    blocksize = 16
    count = len(data)
    padding_amount = blocksize - (count % blocksize)
    padded_data = data + bytes([padding_amount] * padding_amount).hex()
    return bytes.fromhex(padded_data)

plaintext1 = pkcs7_pad('6bc1bee22e409f96e93d7e117393172a')
print(plaintext1.hex())