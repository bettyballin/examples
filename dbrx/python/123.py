from Crypto.PublicKey import RSA

key = RSA.generate(2048)
public_key = key.publickey()

message = b"This is my message"
encrypted_message = pow(int.from_bytes(message, byteorder='big'), public_key.e, public_key.n).to_bytes((public_key.n.bit_length()+7)//8, byteorder='big')

decrypted_message = pow(int.from_bytes(encrypted_message, byteorder='big'), key.d, key.n).to_bytes((key.n.bit_length()+7)//8, byteorder='big')
print(decrypted_message == message)