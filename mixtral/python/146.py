from Crypto.Cipher import PKCS1_OAEP
from Crypto.PublicKey import RSA

def encrypt(file, public_key):
    read_size = 128

    with open(file, 'rb') as original_file:
        e_file = file + '.e'

        cipher = PKCS1_OAEP.new(RSA.importKey(public_key))

        with open(e_file, 'wb') as encrypted_file:
            while True:
                file_part = original_file.read(read_size)

                if len(file_part) == 0:
                    break

                encrypted_file.write(cipher.encrypt(file_part))

def decrypt(file, private_key):
    read_size = 128

    with open(file, 'rb') as encrypted_file:
        d_file = file[:-2]

        cipher = PKCS1_OAEP.new(RSA.importKey(private_key))

        with open(d_file, 'wb') as decrypted_file:
            while True:
                file_part = encrypted_file.read(read_size)

                if len(file_part) == 0:
                    break

                decrypted_file.write(cipher.decrypt(file_part))

# Example usage
public_key = """-----BEGIN PUBLIC KEY-----
...
-----END PUBLIC KEY-----"""

private_key = """-----BEGIN PRIVATE KEY-----
...
-----END PRIVATE KEY-----"""

encrypt('test.txt', public_key)
decrypt('test.txt.e', private_key)