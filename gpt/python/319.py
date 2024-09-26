
def decrypt(text, shift):
    decrypted_text = ''
    for char in text:
        if char.isalpha():  # Check if it's an alphabetic character
            # Preserve the case of the letter
            offset = 65 if char.isupper() else 97
            # Shift back and wrap around the alphabet
            decrypted_char = chr(((ord(char) - offset - shift) % 26) + offset)
            decrypted_text += decrypted_char
        else:
            # Non-alphabetic characters are added as is
            decrypted_text += char
    return decrypted_text

# Example usage:
text = input('ENTER CIPHER HERE: ')
for shift in range(26):  # Try all possible shifts from 0 to 25
