import RSA
from Crypto.Cipher import PKCS1_OAEP, AES
import os
import time

def decrypt(file):
    with open(file, "rb") as file_in:
        data = file_in.read()

    private_key = RSA.import_key(open("private.pem").read())
    enc_session_key, nonce, tag, ciphertext = [data[x:y] for x, y in [(0, private_key.size_in_bytes()), (private_key.size_in_bytes(), private_key.size_in_bytes() + 16), (private_key.size_in_bytes() + 16, private_key.size_in_bytes() + 32), (private_key.size_in_bytes() + 32, -1)]]

    cipher_rsa = PKCS1_OAEP.new(private_key)
    session_key = cipher_rsa.decrypt(enc_session_key)

    with open(str(file[:-4]), "wb") as file_out:
        cipher_aes = AES.new(session_key, AES.MODE_EAX, nonce)
        data = cipher_aes.decrypt_and_verify(ciphertext, tag)
        file_out.write(data)

    print(f"{file} DECRYPT!")
    time.sleep(5)  # You can remove this line if it doesn't help
    os.remove(file)