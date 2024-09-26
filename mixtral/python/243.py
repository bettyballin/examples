import tkinter
from cryptography.fernet import Fernet

class CryptoGraphy:
    def __init__(self):
        self.key = None
        self.token = None
        self.root = tkinter.Tk()
        self.w = tkinter.Text(self.root)
        self.w.pack()

        self.encrypt_button = tkinter.Button(self.root, text="Encrypt", command=self.encrypt)
        self.encrypt_button.pack()

        self.decrypt_button = tkinter.Button(self.root, text="Decrypt", command=self.decrypt)
        self.decrypt_button.pack()

        self.entry = tkinter.Entry(self.root)
        self.entry.pack()

    def encrypt(self):
        string = self.entry.get()
        if not self.key:
            self.key = Fernet.generate_key()

        fernet = Fernet(self.key)

        byteString = str.encode(string)

        self.token = fernet.encrypt(byteString)

        self.w.insert(tkinter.INSERT, self.token.decode() + "\n")

    def decrypt(self):
        if not self.token:
            self.w.insert(tkinter.INSERT, "You didn't yet encrypt anything.\n")

        try:
            fernet = Fernet(self.key)

            decrypted = fernet.decrypt(self.token)

        except (NameError, AttributeError):
            self.w.insert(tkinter.INSERT, "You didn't yet encrypt anything.\n")

        dsAsString = decrypted.decode("utf-8")

        self.w.insert(tkinter.INSERT, dsAsString + "\n")

    def run(self):
        self.root.mainloop()

if __name__ == "__main__":
    crypto = CryptoGraphy()
    crypto.run()