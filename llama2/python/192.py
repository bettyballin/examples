import pyasn1

# Load the PEM file
with open('private_key.pem', 'rb') as f:
    content = f.read()

# Decode the DER-encoded private key
from pyasn1.codec.der import decoder
decoded_object = decoder.decode(content)

# Extract the curve parameters 'a' and 'b'
curve_a = decoded_object[0]
curve_b = decoded_object[1]

print('Curve parameter \"a\":', curve_a)
print('Curve parameter \"b\":', curve_b)