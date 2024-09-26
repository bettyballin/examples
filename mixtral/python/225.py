from Cryptodome.Util import Padding
from Cryptodome.Cipher import DES

key = b'\x01\x02\x03\x04\x05\x06\x07\x08'
des = DES.new(key, DES.MODE_ECB)

message = b'Hello, World!'
ciphertext = des.encrypt(Padding.pad(message, 8))

plain_msg_withpadding = des.decrypt(ciphertext)

print("Decrypted including padding:", plain_msg_withpadding[:-plain_msg_withpadding[-1]])