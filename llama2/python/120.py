import tkinter
from cryptography.fernet import Fernet

def encrypt_decrypt():
    # Create a sample string to encrypt
    string = entry.get("1.0", "end-1c")

    # Encrypt the string
    key = Fernet.generate_key()
    f = Fernet(key)
    byteString = str.encode(string)
    token = f.encrypt(byteString)

    # Decrypt the token
    try:
        decrypted = f.decrypt(token)
    except (NameError, AttributeError):
        result.delete("1.0", tkinter.END)
        result.insert(tkinter.END, "You didn't encrypt anything!")
    else:
        result.delete("1.0", tkinter.END)
        result.insert(tkinter.END, decrypted.decode("utf-8"))

root = tkinter.Tk()
root.title("Encrypt Decrypt")

label = tkinter.Label(root, text="Enter a message:")
label.pack()

entry = tkinter.Text(root, height=10, width=40)
entry.pack()

button = tkinter.Button(root, text="Encrypt/Decrypt", command=encrypt_decrypt)
button.pack()

result = tkinter.Text(root, height=10, width=40)
result.pack()

root.mainloop()