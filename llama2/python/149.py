import ssl
from flask import Flask

with open('MyPEMFile.pem', 'r') as f:
    pem_reader = ssl.PEM_cert_to_DER_cert(f.read())

private_key = ssl.PEM_key_to_DER_cert(f.read())
certificate = ssl.PEM_cert_to_DER_cert(f.read())

context = ssl.create_default_context()
context.check_hostname = False
context.verify_mode = ssl.CERT_REQUIRED
context.load_cert_chain(certificate, private_key)

app = Flask(__name__)

if __name__ == '__main__':
    ssl_context = context
    app.run(ssl_context=ssl_context)