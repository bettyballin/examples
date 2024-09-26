from Crypto.PublicKey import ECC

# Generate new keys
key = ECC.generate(curve='P-256')

# Export private key
private_pem = key.export_key(format='PEM')

# Import the same private key
imported_key = ECC.import_key(private_pem)

print(private_pem.decode())
print(imported_key.export_key(format='PEM').decode())