import hashlib
from pbkdf2 import crypt

def validate_password(hashed, plain):
    # Extract the parameters from the stored hash
    algo, iterations, salt, hashed = hashed.split('$')

    # Generate a new hash with the same settings
    generated = crypt(plain, salt=salt[:29], type='pbkdf2_sha512', rounds=int(iterations))

    return hashed == generated

# Example usage
hashed_password = "pbkdf2_sha512$100000$some_salt$some_hashed_password"
plain_password = "my_plain_password"

is_valid = validate_password(hashed_password, plain_password)
print(is_valid)