from cryptography.fernet import Fernet, MultiFernet

# Define a keystore with multiple keys
keystore = [Fernet.generate_key() for _ in range(3)]

# Create a list of Fernet instances
fernet_instances = [Fernet(key) for key in keystore]

# Initialize MultiFernet with the list of Fernet instances
multi_fernet = MultiFernet(fernet_instances)

# Use MultiFernet to encrypt data
ciphertext = multi_fernet.encrypt(b"Hello World!")

# Decrypt using the individual Fernet instances
for i, f in enumerate(fernet_instances):
    print(f"Decrypted with key {keystore[i]} : {f.decrypt(ciphertext)}")