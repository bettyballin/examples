import base64

def encrypt_string(input_str):
    encoded = input_str.encode()

    return base64.b85encode(encoded).decode("ascii")

# Usage
encrypted_text = encrypt_string("Hello World!")
print(f"Encrypted text: {encrypted_text}")

def decrypt_string(input_str):
    encoded = input_str.encode()

    return base64.b85decode(encoded).decode('utf-8')

# Usage
decrypted_text = decrypt_string(encrypted_text)
print(f"Decrypted text: {decrypted_text}")