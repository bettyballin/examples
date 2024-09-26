def decrypt(encrypted):
    NewString = ""
    for letter in range(len(encrypted)):
        NewString += chr(ord(encrypted[letter])-4)
    return NewString

encrypted = "your_encrypted_string_here"
print(decrypt(encrypted))