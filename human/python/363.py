from cryptography.fernet import Fernet, MultiFernet

keystore = []
keyfinal = []

message = b"foo bar"    
for x in range(4):

    keystore.append(Fernet.generate_key()) # generates the initial keys
    keyfinal.append(Fernet(keystore[x])) # Applies Fernet encryption to make usable keys

f = MultiFernet(keyfinal) # Set up MultiFernet on the keyfinal list
s = Fernet(keystore[2]) # Take a key from the initial keystore for single key encryption

token = s.encrypt(message) # encrypt using single key

try:
    print(f.decrypt(token)) # decrypt using MultiFernet
except:
    print("Error: The key used for encryption is not in the MultiFernet key list.")