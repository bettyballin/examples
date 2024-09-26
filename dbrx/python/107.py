import base64

def vigenere_encrypt(plaintext, key):
    encrypted = ""
    for i in range(len(plaintext)):
        char_code = ord(plaintext[i])
        shift = (ord(key[i % len(key)]) - 97) * (-1 if plaintext[i].islower() else 1)
        new_char_code = ((char_code - 65 + shift) % 26) + 65 if char_code >= 65 and char_code <= 90 else ((char_code - 97 + shift) % 26) + 97
        encrypted += chr(new_char_code)

    return base64.b64encode(encrypted.encode()).decode()

# Test the function
plaintext = "HelloWorld"
key = "secretkey"
print(vigenere_encrypt(plaintext, key))