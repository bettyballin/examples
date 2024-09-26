from Crypto.Cipher import AES # pip install pycryptodome
import os

def aes_cfb(data, key, iv):
    ctx = AES.new(key, AES.MODE_CFB, iv = iv, segment_size = 128)
    decrypted = ctx.decrypt(data)
    return decrypted

filesize = os.stat('./encrypted.txt').st_size

with open('./encrypted.txt','rb') as rf:
    data = rf.read(filesize)
    decrypted = aes_cfb(data, 
                        bytearray.fromhex('3398699acebda0dab39a46f5cc4f0d45'),
                        bytearray.fromhex('b39a46f5cc4f0d45b39a46f5cc4f0d45') 
                       )

with open('./config.xml', 'wb') as wf:
    wf.write(decrypted)