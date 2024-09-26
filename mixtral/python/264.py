from cryptography.fernet import Fernet
import base64

def encrypt_string(data, password):
    f = get_fernet_(password)

    # Encoding the data as bytes and then converting it to a Base64-encoded string
    ciphertext = base64.urlsafe_b64encode(f.encrypt(data.encode('utf8')))

    return ciphertext.decode('utf8')

def decrypt_string(base64_ciphertext, password):
    f = get_fernet_(password)

    # Decoding the Base64-encoded ciphertext back into bytes
    b64decoded_bytes = base64.urlsafe_b64decode(base64_ciphertext)

    return f.decrypt(b64decoded_bytes).decode('utf8')

def get_fernet_(password):
    key = Fernet.generate_key()
    f = Fernet(key)
    return f

def test_encryption(data):
    password = "password123"
    encrypted = encrypt_string(data, password)
    decrypted = decrypt_string(encrypted, password)
    return data == decrypted

# Testing the functions
print(test_encryption("test\tstring"))  # Should print True