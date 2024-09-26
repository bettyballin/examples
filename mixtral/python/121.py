def Encrypt(plainText, key):
    codedText = []

    for char in plainText:
        codedChar = ord(char) + key
        codedText.append(codedChar)

    return bytes(codedText)

# Example usage:
plainText = "Hello, World!"
key = 3
encryptedText = Encrypt(plainText, key)
print(encryptedText)