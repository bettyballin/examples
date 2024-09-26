
def encryption():
    print('In Encryption')
    input1 = ent1.get()
    FileName = str(input1) + ".txt"
    input2 = ent2.get()
    wrcont = str(input2)
    with open(FileName, 'wb') as TextFile:  # Open the file in write mode to save the original content
        TextFile.write(wrcont.encode())  # Write the original content
    fernet = Fernet(key)
    with open(FileName, 'rb') as TextFile:  # Reopen the file to read the written content
        data = TextFile.read()
    encrypted = fernet.encrypt(data)
    with open(FileName, 'wb') as TextFile: 
