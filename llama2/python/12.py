from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad

text = """This is plain text
to use.
It should be exactly 128 characters long to avoid padding and it is split
with new lines as in
file"""

password = "password........".encode()
block = 32
mode = AES.MODE_CBC

enc = AES.new(password, mode)

# Pad the plaintext to a multiple of 32
padded_text = pad(text.encode(), block)

encrypted = enc.encrypt(padded_text)

print("ORIGINAL: " + text)

print("ENCRYPTED: " + str(encrypted))

decrypted = enc.decrypt(encrypted)
unpadded_text = unpad(decrypted, block)

print("DECRYPTED: " + unpadded_text.decode())