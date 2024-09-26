
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
from Crypto.Random import get_random_bytes

def encrypt_file(input_file_path, output_file_path, key):
    buffer_size = 65536  # 64kb
    iv = get_random_bytes(AES.block_size)
    
    cipher = AES.new(key, AES.MODE_CBC, iv)
    
    with open(input_file_path, 'rb') as infile, open(output_file_path, 'wb') as outfile:
        outfile.write(iv)  # Write the IV to the output file
