import binascii

hex_representation = "your-key"
derived_key = binascii.unhexlify(hex_representation.replace("-", ""))

# Now use derived_key
print(derived_key)