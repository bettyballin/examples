import secrets

random_number = int.from_bytes(secrets.token_bytes(16), byteorder='big')

print(random_number)