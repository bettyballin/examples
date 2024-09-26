import rsa

public_key, private_key = rsa.newkeys(1024)
print("Key generated")
print("Public key", public_key)

message = 'To be, or not to be - that is the question.'
encrypted_message = rsa.encrypt(message.encode(), public_key)
print(encrypted_message)

decrypted_message = rsa.decrypt(encrypted_message, private_key).decode()
print(decrypted_message)