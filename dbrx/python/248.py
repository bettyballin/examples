import base64

def encrypt(text):
    return base64.b64encode(bytes(text, 'utf-8')).decode()

def decrypt(number):
    return base64.b64decode(bytes(number, 'utf-8')).decode()

# Example usage:
text = "Hello, World!"
encrypted = encrypt(text)
print(f"Encrypted: {encrypted}")

decrypted = decrypt(encrypted)
print(f"Decrypted: {decrypted}")