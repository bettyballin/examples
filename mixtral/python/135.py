import hashlib
import binascii
import os

def generate_salt(length=16):
  return os.urandom(length).hex()

def get_hashed_ssn(ssn, salt):
    ssn = bytes(str(ssn), 'utf-8')
    salt = bytes(salt, 'utf-8')
    hasher = hashlib.sha256(salt + ssn)

    return binascii.hexlify(hasher.digest()).decode()

# Test the functions
salt = generate_salt()
ssn = "123456789"
hashed_ssn = get_hashed_ssn(ssn, salt)

print("Salt:", salt)
print("Hashed SSN:", hashed_ssn)