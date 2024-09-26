import hashlib

def encrypt_string(input_str):
    result = hashlib.sha256()
    result.update(input_str.encode())

    return result.hexdigest()

# Usage
encrypted_text = encrypt_string("Hello World!")
print(f"Encrypted text: {encrypted_text}")