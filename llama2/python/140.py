import string

def decrypt(text, shift):
    # Convert text to uppercase
    text = text.upper()

    # Create a dictionary with 26 keys (A-Z) and their corresponding shifted values
    dict = {}
    for i in range(26):
        dict[chr(i + 65)] = chr((i - shift) % 26 + 65)

    # Iterate through the encrypted text
    decrypted_text = ''
    for char in text:
        if char.isalpha():
            decrypted_text += dict[char]
        else:
            decrypted_text += char

    return decrypted_text

# Example usage:
text = "KHOOR ZRUOG"
shift = 3
print(decrypt(text, shift))