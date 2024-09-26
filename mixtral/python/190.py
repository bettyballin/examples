from Cryptodome.PublicKey import RSA

key = RSA.generate(4096)
message = b"Hello World!"
encrypted_msg = key.publickey().encrypt(message, 32)[0]
decrypted_msg = key.decrypt(encrypted_msg).decode()

print("Original message:", message)
print("Encrypted message:", encrypted_msg)
print("Decrypted message:", decrypted_msg)