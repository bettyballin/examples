
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

# Read the private key from the PEM file
with open('private_key.pem', 'rb') as key_file:
    private_key = serialization.load_pem_private_key(
        key_file.read(),
        password=None,  # Use `password=b'mypassword'` if the PEM file is password-protected
        backend=default_backend()
    )

# Extract the private key's numbers which includes the private key integer (d)
private_numbers = private_key.private_numbers()
private_key_integer = private_numbers.private_value

# Print the private key integer
print(private_key_integer)

