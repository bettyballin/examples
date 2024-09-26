def remove_pkcs7_padding(data):
    return data[:-ord(data[len(data)-1:])]

from Crypto.Cipher import AES

# assuming 'key' is your decryption key
key = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'
decipher = AES.new(key, AES.MODE_ECB)

# assuming 'ciphertext' is your encrypted data
ciphertext = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'

plaintext = decipher.decrypt(ciphertext)
plaintext = remove_pkcs7_padding(plaintext)