from tkinter import Tk, Entry, Button
from cryptography.fernet import Fernet

key = Fernet.generate_key()
fernet = Fernet(key)

root = Tk()
ent1 = Entry(root)
ent1.pack()

def decryption():
    input1 = ent1.get()
    file = str(input1) + ".txt"
    
    print('In Decryption')
    with open(file, 'rb') as TextFile:
        token = TextFile.read()

    fernet = Fernet(key)
    decrypted = fernet.decrypt(token)

    # write the encrypted file
    new_file = file[:-4] + "_decrypted.txt"  # create a different filename for decryption output
    with open(new_file, 'wb') as DecTextFile:
        DecTextFile.write(decrypted)

    print('Decrypted data:')
    print(decrypted.decode())

btn = Button(root, text="Decrypt", command=decryption)
btn.pack()

root.mainloop()