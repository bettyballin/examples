import os

# Generate a key
key = os.urandom(32)

# Write the key to a file
with open('key.key','wb') as file:
    file.write(key)

# Read the key from the file
with open('key.key','rb') as file:
    key = file.read()

print(key)