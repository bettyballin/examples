import tkinter as tk
from cryptography.fernet import Fernet

class Cryptography:
    def __init__(self):
        self.key = Fernet.generate_key()
        self.f = Fernet(self.key)
        self.token = None

    def encrypt(self, string):
        byte_string = str.encode(string)
        self.token = self.f.encrypt(byte_string).decode("utf-8")
        w.insert(tk.INSERT, f"Encrypted: {self.token}\n")
        w.pack()

    def decrypt(self):
        try:
            decrypted_bytes = self.f.decrypt(self.token.encode("utf-8"))
            ds_as_string = decrypted_bytes.decode("utf-8")
            w.insert(tk.INSERT, f"Decrypted: {ds_as_string}\n")
        except (NameError, AttributeError):
            w.insert(tk.INSERT, "You didn't yet encrypt anything\n")

w = tk.Text()
root = tk.Tk()

c = Cryptography()
tk.Button(root, text="Encrypt", command=lambda: c.encrypt("Hello")).pack()
tk.Button(root, text="Decrypt", command=c.decrypt).pack()

root.mainloop()