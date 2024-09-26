def encrypt(text):
    result = ""
    for char in text:
        if char.islower():
            result += chr(ord('z') - ord(char) + ord('a'))
        elif char.isupper():
            result += chr(ord('Z') - ord(char) + ord('A'))
        else:
            result += char
    return result

print(encrypt("ABC")) # Output: ZYX