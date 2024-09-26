f = open('decrypted.txt', 'wb')
f.write(decryptoor.decrypt(encrypted))
f.close()
print("Decryption successful!")