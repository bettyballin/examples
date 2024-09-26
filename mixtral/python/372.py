import base64

# Replace with your encoded key and initialization vector
your_encoded_key = "your_encoded_key_here"
your_encoded_initializationVector = "your_encoded_initializationVector_here"

# Decode the key
key = base64.b64decode(your_encoded_key)

# Decode the initialization vector
iv = base64.b64decode(your_encoded_initializationVector)

# Ensure they are 128 bits (16 bytes as required by AES-CBC
assert len(key) == 16
assert len(iv) == 16

if __name__ == "__main__":
    try:
        print("Key:", key)
        print("IV:", iv)
    except AssertionError:
        print("Error: Key or IV is not 16 bytes long.")