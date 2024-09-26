import ecdsa

# Generate private key
sk = ecdsa.SigningKey.generate(curve=ecdsa.SECP256k1)

# Generate public key
vk = sk.get_verifying_key()

# Get public key in PEM format
public_key_pem = vk.to_pem().decode('utf-8')

# Get public key in DER format
public_key_der = vk.to_der()

# Print public key in PEM format
print("<p style='font-family:'Courier New', monospace;' id='pub'>")
print(public_key_pem)
print("</p>")

# Sign a message
message = b"Hello, world!"
signature = sk.sign(message)

# Print signature in DER format
print("<p style='font-family:'Courier New', monospace;' id='sig'>")
print(signature.hex())
print("</p>")