def decrypt(ciphertext, n):
    result = ''
    for i in range(len(ciphertext)):
        char = ciphertext[i]
        if char.isupper():
            result += chr((ord(char) - 65 - n) % 26 + 65)
        elif char.islower():
            result += chr((ord(char) - 97 - n) % 26 + 97)
        else:
            result += char
    return result

x = 'dd3364...7c02'  # your ciphertext
n = 2

result = decrypt(x, n)
print("Final result:", result)