def cipher(string):
    encrypted = ""

    # Iterate over each character in the string
    for letter in range(len(string)):
        NewX = ord(string[letter])

        # Shift by 4 and convert back to a char
        shifted_char = chr((NewX + 4) % 256)

        encrypted += shifted_char

    return encrypted

def decipher(encrypted):

    NewString   = ""

    # Iterate over each character in the string
    for letter in range(len(encrypted)):

        # Shift back by 4 and convert to a char
        shifted_char = chr((ord(encrypted[letter]) - 4) % 256)

        NewString += shifted_char

    return NewString

def main():
    string = input("enter your string here: ")

    # Store the returned value from cipher function
    encrypted = cipher(string)

    print('Encrypted text is :', encrypted)

    decrypted_text  = decipher(encrypted)

    print('Decrypted Text is :', decrypted_text)

main()