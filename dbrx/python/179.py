from cryptography.fernet import Fernet

entry1 = "First_sentence"
entry2 = "Second_sentence"
entry3 = "Third_sentence"

##--- Key creation
firstKey = Fernet.generate_key()
with open('.\\TEST\\key.key', 'wb') as file:
    file.write(firstKey)

##--- Cipher entries
key = Fernet(firstKey)
chiffrentry1 = key.encrypt(bytes(entry1, "utf-8"))
chiffrentry2 = key.encrypt(bytes(entry2, "utf-8"))
chiffrentry3 = key.encrypt(bytes(entry3, "utf-8"))

listAll = [chiffrentry1, chiffrentry2, chiffrentry3]

##-- Write cipher text in file
with open('.\\TEST\\text_encrypt.txt', 'wb') as pt:
    for ligne in listAll:
        pt.write(ligne + b'\n')

##--- Recover file to decrypt cipher text
listCipher = []

with open('.\\TEST\\text_encrypt.txt', 'rb') as pt:
    for line in pt:
        listCipher.append(line.strip())

exit1, exit2, exit3 = key.decrypt(listCipher[0]), key.decrypt(listCipher[1]), key.decrypt(listCipher[2])

print(exit1.decode("utf-8"))
print(exit2.decode("utf-8"))
print(exit3.decode("utf-8"))