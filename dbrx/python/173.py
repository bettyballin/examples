import os
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

KEY_SIZE = 2048
PUBLIC_EXP = 65537

def generate_unique_rsa_key():
    # Generate two random primes using a CSPRNG.
    key1 = rsa.generate_private_key(
        public_exponent=PUBLIC_EXP,
        key_size=KEY_SIZE // 2 + KEY_SIZE % 2,
        backend=default_backend()
    )
    key2 = rsa.generate_private_key(
        public_exponent=PUBLIC_EXP,
        key_size=KEY_SIZE // 2,
        backend=default_backend()
    )
    p = key1.private_numbers().p
    q = key2.private_numbers().p

    # Calculate the modulus and private exponent.
    n = p * q
    phi_n = (p - 1) * (q - 1)
    d = pow(PUBLIC_EXP, -1, phi_n)

    return rsa.RSAPrivateNumbers(
        p=p,
        q=q,
        d=d,
        dmp1=d % (p - 1),
        dmq1=d % (q - 1),
        iqmp=pow(q, -1, p),
        public_numbers=rsa.RSAPublicNumbers(e=PUBLIC_EXP, n=n)
    ).private_key(default_backend())

# Generate a unique RSA key.
unique_private_key = generate_unique_rsa_key()

# Convert the generated key to PEM format and store it as string in Django model field.
private_key_str = unique_private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.TraditionalOpenSSL,
    encryption_algorithm=serialization.NoEncryption()
).decode()

print(private_key_str)