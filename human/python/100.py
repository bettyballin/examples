key = "example"
alphabet = "abcdefghijklmnopqrstuvwxyz"

for c in key:
    alphabet = alphabet.replace(c, "")

print(alphabet)