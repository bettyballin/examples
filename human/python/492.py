sh = int(input())
s = input()
n = ""
for char in s:
    val = ord(char)-sh
    if char.isupper() and char.isalpha():
        if 65 <= val <= 90:
            n += chr(val)
        else:
            n += chr(90 - (65 - val - 1))
    elif char.islower() and char.isalpha():
        if 97 <= val <= 122:
            n += chr(val)
        else:
            n += chr(122 - (97 - val - 1))
    else:
        n += char
print(n)