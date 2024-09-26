
sh = int(input())
s = input()
n = ""

def shift_char(c, shift_amount):
    if 'A' <= c <= 'Z':
        return chr((ord(c) - shift_amount - 65) % 26 + 65)
    elif '0' <= c <= '9':
        return chr((ord(c) - shift_amount - 48) % 10 + 48)
    else:
        return c

for char in s:
    if char.isalpha() and char.isupper():
        val = ord(char) - sh
        if val < 65:
            n += chr(90 - (65 - val - 1))
