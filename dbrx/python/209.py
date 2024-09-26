import binascii

privateKey = "your_private_key_here"
private_key_hex = binascii.hexlify(privateKey.encode()).decode()