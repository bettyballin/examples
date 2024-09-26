import tkinter as tk
from cryptography.fernet import Fernet

key = Fernet.generate_key()
cipher_suite = Fernet(key)

MEDIUM_FONT = ("Berlin Sans FB", 12)
LARGE_FONT = ("Berlin Sans FB", 16)

# validate function
def validateStylist():
    password = bytes(passwordEntry.get(), 'utf-8')
    cipher_text = cipher_suite.encrypt(password)
    plain_text = cipher_suite.decrypt(cipher_text).decode('utf-8')
    print(plain_text)

window = tk.Tk()

titleLabel = tk.Label(window, text="Register Stylist", font=LARGE_FONT, bg="#FFC0CB")
titleLabel.grid(columnspan=4)

# Password
passwordLabel = tk.Label(window, text="Password:", font=MEDIUM_FONT, bg="#FFC0CB")
passwordLabel.grid(row=1, column=3)

passwordVar = tk.StringVar()
passwordEntry = tk.Entry(window, show='*', textvariable=passwordVar)
passwordEntry.grid(row=2, column=3)

finishButton = tk.Button(window, text="Finish", command=validateStylist)
finishButton.grid(row=4, column=3, sticky="ew")

window.mainloop()