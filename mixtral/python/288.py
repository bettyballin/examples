import os

file = "encrypted_file.txt"

with open(file, "rb") as file_in, \
     open(str(file[:-4]) + "_decrypted" + file[-4:], "wb") as file_out:
    # Your decryption code here
    pass  # Replace with your decryption code

os.remove(file)