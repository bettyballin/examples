import string

chaine = "Hello, World!"
app = [0] * 26

for c in chaine.upper() :
    if c in string.ascii_uppercase :
        app[ord(c) - ord('A')] += 1

print(app)