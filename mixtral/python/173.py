from cryptography.fernet import Fernet

# assuming storage and to_decrypt are defined elsewhere
f = Fernet(storage["key"])
print("decrypted:", f.decrypt(storage[to_decrypt]).decode('utf-8'))