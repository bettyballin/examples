def caesar_cipher(text: str, shift: int):
    result = ""
    # traverse text
    for i in range(len(text)):
        char = text[i]
        
        if (char.isupper()):
            shifted_char = chr((ord(char) + shift - 65) % 26 + 65)
        else:
            shifted_char = chr((ord(char) + shift - 97) % 26 + 97)

        result += shifted_char
    return result

# test the function
print(caesar_cipher("ATTACKATDAWN", 3))