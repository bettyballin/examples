sh = int(input())
s = input()
n = ""
for char in s:
    val = ord(char)-sh

    # Check for non-alphabet characters
    if not (65 <= ord(char) <= 90):
        n += char

    elif 'A' <= chr(val) <= 'Z':
        n += chr(val)

    else:
        n += chr(90 - (64 - val))

print(n)