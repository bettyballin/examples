def vigenere_encrypt(plaintext, key):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    encrypted = ""
    key_index = 0
    for char in plaintext:
        if char.isalpha():
            shift = alphabet.index(key[key_index % len(key)].lower())
            if char.isupper():
                encrypted += chr((ord(char) - ord('A') + shift) % 26 + ord('A'))
            else:
                encrypted += chr((ord(char) - ord('a') + shift) % 26 + ord('a'))
            key_index += 1
        else:
            encrypted += char
    return encrypted

plaintext = "s+Dd6djk3Jfq6dq0md/..."
key = "w"
print(vigenere_encrypt(plaintext, key))