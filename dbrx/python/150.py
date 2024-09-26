import tkinter as tk
from cryptography.fernet import Fernet

# Initialize the cipher suite
cipher_suite = Fernet.generate_key()
cipher_suite = Fernet(cipher_suite)

def validateStylist(window):
    password = str(passwordEntry.get()).encode()
    cipher_text = cipher_suite.encrypt(password)
    plain_text = cipher_suite.decrypt(cipher_text)
    print(plain_text)

window = tk.Tk()

passwordVar  = tk.StringVar(window)
passwordEntry  = tk.Entry(window, textvariable=passwordVar)

finishButton  = tk.Button(window, text="Finish", command=lambda: validateStylist(window))

passwordEntry.pack()
finishButton.pack()

window.mainloop()