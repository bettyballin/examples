
from Crypto.Cipher import AES

k = '57067125438768260656188878670043'
key = bytes(k, 'ascii')
i = '5706712543876826'
iv = bytes(i, 'ascii')

def unpad(s):
    return s[:-s[-1]]

def decrypt(ciphertext, key, iv, n):
    cipher = AES.new(key, AES.MODE_CBC, iv)
    plaintext = ciphertext
    for _ in range(n):
        decrypted_data = cipher.decrypt(plaintext)
        # After each decryption
