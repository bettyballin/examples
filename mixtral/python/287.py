def decrypt(text, shift):
    b = ''

    for i in range(len(text)):
        s1 = chr(((ord(text[i]) - 65 + (26-shift)) % 26) + 65)

        # If the character is lowercase
        if text[i].islower():
            b += chr((ord(s1.lower())))

        else:
           b = b + s1

    print(b)

# Test the function
decrypt("Khoor Zruog", 3)