import hashlib

bytes_representation = b"Hello, World!"
hashed_value = hashlib.sha256(bytes_representation).hexdigest()
print(hashed_value)