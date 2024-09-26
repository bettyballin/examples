def caesar_cipher(plaintext, shift):
    ciphertext = ""
    for char in plaintext:
        if char.isalpha():
            if char.isupper():
                position = ord(char) - ord('A')
                position = (position + shift) % 26
                ciphertext += chr(ord('A') + position)
            else:
                position = ord(char) - ord('a')
                position = (position + shift) % 26
                ciphertext += chr(ord('a') + position)
        else:
            ciphertext += char
    return ciphertext

plaintext = input("Enter plaintext: ")
shift = int(input("Enter shift value: "))
print("Ciphertext:", caesar_cipher(plaintext, shift))