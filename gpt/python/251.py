
import tkinter as tk
from cryptography.fernet import Fernet

# validate function
def validateStylist(window):
    password = passwordEntry.get().encode("utf-8")
    cipher_text = cipher_suite.encrypt(password)
    plain_text = cipher_suite.decrypt(cipher_text)
    print(plain_text)

key = Fernet.generate_key()
cipher_suite = Fernet(key)

MEDIUM_FONT = ("Berlin Sans FB", 12)
LARGE_FONT = ("Berlin Sans FB", 16)

window = tk.Tk()

titleLabel = tk.Label(window, text="Register Sty
