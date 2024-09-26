from Crypto.Cipher import AES

key = b'LKOXBRRUNBOSMENKEPPZUKWB'
counter = b'HOJFKGQMRCTKUQHP'

cipher = AES.new(key, AES.MODE_CTR, counter=counter)
encrypted_data = cipher.encrypt(b'Testing--StackOverflow')
print(encrypted_data.hex())