def Encrypt(plain_text, key):
    cipher = []

    # XOR all keys together
    KeyA = 0
    for n in range(len(key)):
        KeyA ^= key[n]

    nKeyPos = KeyA % len(key)

    plainText = [ord(c) for c in plain_text]

    # Encrypt each character
    for i, char in enumerate(plainText):
        codeChar = ((char ^ key[nKeyPos]) * KeyA).to_bytes((char.bit_length() + 7) // 8, 'big')

        if len(codeChar) > 0:
            cipher.append(int.from_bytes(codeChar, byteorder='little'))

    return bytes(cipher)

# Example usage:
key = [1, 2, 3, 4, 5]
plain_text = "Hello, World!"
encrypted = Encrypt(plain_text, key)
print(encrypted)