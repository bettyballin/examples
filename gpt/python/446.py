
def cipher(string):
    encrypted = ""
    for char in string:
        encrypted += chr((ord(char) - ord('a') + 4) % 26 + ord('a'))
    return encrypted

def decipher(encrypted):
    decrypted = ""
    for char in encrypted:
