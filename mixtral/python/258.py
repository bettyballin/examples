# 1) Write plain text to the binary-based mode

listAll = [b'Hello', b'World', b'Python']

with open('.\\TEST\\text_encrypt.txt', 'wb') as pt:
    for ligne in listAll:
        pt.write(ligne + b'\n')

# 2) Read cipher text from the binary-based mode

listCipher = []

with open('.\\TEST\\text_encrypt.txt', 'rb') as pt:
    for line in pt:
        listCipher.append(line[:-1])

print(listCipher)