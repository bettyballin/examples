from Crypto.Cipher import AES

k = b'your_key_here'  # 16-byte key
IV = b'your_iv_here'  # 16-byte initialization vector
p = b'your_plaintext_here'  # plaintext to encrypt

for i in range(2):
    enc = AES.new(k, AES.MODE_CBC, IV)   
    p = enc.encrypt(p)
    print(p)