
from M2Crypto import EVP

# Load the private key from a PEM file
privkey = EVP.load_key("privkey.pem")

# Initialize the signing operation
privkey.sign_init()

# Specify the data to sign
text = "The data to sign"

# Update the signing operation with the actual data
privkey.sign_update(text)

# Finalize the signing operation to produce the signature
