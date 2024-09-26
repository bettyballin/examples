def decode_caesar(s):
    for i in range(1, 95):
        decoded = ""
        for char in s:
            if ord(char) + i > 126:
                decoded += chr((ord(char) - 32 + i) % 94 + 32)
            else:
                decoded += chr(ord(char) + i)
        print(decoded)

decode_caesar("T! x$r&'}r&z! %21j!'1~zxy&1\\\"r%%1TZedBEAB?")