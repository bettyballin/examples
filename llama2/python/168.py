import os
from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

# Define the cipher with a randomly generated key and IV
key = get_random_bytes(32)
iv = get_random_bytes(16)
cipher1 = AES.new(key, AES.MODE_CBC, iv)

# Assuming df is a pandas DataFrame
import pandas as pd
df = pd.DataFrame({'values': ['message1', 'message2', 'message3', 'message4', 'Hello, World!']})

# Encrypt the message
message = df['values'][4].encode('utf-8')
def encrypt(message, cipher):
    return cipher.encrypt(message)
eypt = encrypt(message, cipher1)

# Decrypt the message
def decrypt(eypt, cipher):
    return cipher.decrypt(eypt).decode('utf-8')
cipher2 = AES.new(key, AES.MODE_CBC, iv)
original_url = decrypt(eypt, cipher2)

print(original_url)