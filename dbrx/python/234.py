from cryptography.fernet import Fernet

def encrypt_value(value, f):
    return f.encrypt(value.encode()).decode()

def is_encrypted(value):
    return value.startswith('gAAAA')

key = Fernet.generate_key()
f = Fernet(key)
value_to_encrypt = 'sensitive_data'
if not is_encrypted(value_to_encrypt):
    encrypted_value = encrypt_value(value_to_encrypt, f)
    print(f'Encrypted value: {encrypted_value}')
else:
    print(f'Value {value_to_encrypt} already seems to be encrypted.')