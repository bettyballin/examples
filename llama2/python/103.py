import tkinter as tk
from cryptography.fernet import Fernet

# Create the main window
window = tk.Tk()
window.title("Password Validator")

# Create a password entry field
passwordEntry = tk.Entry(window, show="*")
passwordEntry.pack()

# Function to encrypt password
def encrypt(password, cipher_text):
    cipher_suite = Fernet(cipher_text)
    return cipher_suite.encrypt(password)

# Function to get stored password (replace with actual implementation)
def get_stored_password(cipher_text):
    # Replace with actual stored password retrieval logic
    return b"your_stored_password_here"

# Validate function
def validateStylist():
    password = passwordEntry.get().encode("utf-8")
    cipher_text = Fernet.generate_key()
    encrypted_password = encrypt(password, cipher_text)
    stored_password = get_stored_password(cipher_text)
    if encrypted_password == stored_password:
        print("Password validated!")
    else:
        print("Invalid password.")

# Modified Button widget
finishButton = tk.Button(window, text="Finish", command=validateStylist)
finishButton.pack()

# Run the application
window.mainloop()