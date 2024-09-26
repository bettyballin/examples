from cryptography.hazmat.primitives.asymmetric import ec

filename = "path_to_your_file.pem"  # replace with your file path

with open(filename, "rb") as f:
    pem_data = f.read()

private_key = ec.EllipticCurvePrivateKey.from_pem(pem_data)
private_key_int = private_key.private_numbers().private_value