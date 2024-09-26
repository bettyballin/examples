import rsa
with open('key.pem', 'r') as f:
    cert = f.read()
private_key = rsa.PrivateKey.load_pkcs1(cert)
payload = 'foople'.encode('utf8')
signature = rsa.sign(payload, private_key, 'SHA-256')
print(signature.hex())