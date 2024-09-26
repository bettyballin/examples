from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec

def gen_key():
    return ec.generate_private_key(ec.SECP256R1(), default_backend())

key = gen_key()
print(key.private_numbers())
print(key.private_numbers().private_value)
print(format(key.private_numbers().private_value, '064x'))