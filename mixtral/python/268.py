from cryptography.fernet import Fernet
import tkinter as tk

# Create a key
key = Fernet.generate_key()

# Create a Tkinter window
window = tk.Tk()
window.title("Encryption and Decryption")

# Create entry fields for encryption
tk.Label(window, text="File Name:").grid(row=0, column=0)
ent1 = tk.Entry(window)
ent1.grid(row=0, column=1)

tk.Label(window, text="Data to Encrypt:").grid(row=1, column=0)
ent2 = tk.Entry(window)
ent2.grid(row=1, column=1)

# Create entry fields for decryption
tk.Label(window, text="File Name:").grid(row=2, column=0)
ent4 = tk.Entry(window)
ent4.grid(row=2, column=1)

# Function to encrypt data
def encryption():
    input1 = ent1.get()
    FileName = str(input1)+".txt"

    with open(FileName, 'wb') as TextFile:
        fernet = Fernet(key)

        # Get the data from entry
        wrcont = ent2.get().encode('utf-8')

        encrypted_data = fernet.encrypt(wrcont)

        print("Encrypted Data:", encrypted_data)

        TextFile.write(encrypted_data)

# Function to decrypt data
def decryption():
    input1 = ent4.get()

    FileName = str(input1)+".txt"

    with open(FileName, 'rb') as TextFile:

        fernet = Fernet(key)

        encrypted_data = TextFile.read()

        decrypted_data = fernet.decrypt(encrypted_data).decode('utf-8')

        print("Decrypted Data:", decrypted_data)

# Create buttons to call functions
tk.Button(window, text="Encrypt", command=encryption).grid(row=1, column=2)
tk.Button(window, text="Decrypt", command=decryption).grid(row=2, column=2)

window.mainloop()