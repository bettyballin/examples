Here is the corrected code:


import base64
import random
import string

def xor_encrypt(data, key):
    result = ""

    for i in range(len(data)):
        char = data[i]
        keyChar = key[i % len(key)]

        encryptedChar = chr((ord(char) ^ ord(keyChar)))

        if (encryptedChar.isprintable()):
            result += encryptedChar

    return base64.b64encode(result.encode()).decode('utf-8')

def generate_random_string():
    length = 10
    lettersAndDigits = string.ascii_letters + string.digits
    return ''.join((random.choice(lettersAndDigits) for i in range(length)))

def encrypt(data, key=None):
    if not key:
        key = generate_random_string()

    ciphertext = xor_encrypt(data, key)

    return (ciphertext + "|" + key)

# Example usage
data = "Hello, World!"
print(encrypt(data))