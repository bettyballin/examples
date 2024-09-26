from api import app
import os
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.serialization import pkcs12
from gevent.pywsgi import WSGIServer

with open(r"C:\Desktop\MyPEMFile.pem", "rb") as pem_file:
    private_key, certificate = pkcs12.load_pem(pem_file)

if not os.path.exists("APIKEY.key"):
    with open("APIKEY.key", "wb") as key_file:
        key_file.write(private_key.private_bytes(
            encoding=serialization.Encoding.PEM,
            format=serialization.PrivateFormat.TraditionalOpenSSL,
            encryption_algorithm=serialization.NoEncryption()
        ))

if not os.path.exists("APICERTIFICATE.crt"):
    with open("APICERTIFICATE.crt", "wb") as cert_file:
        for c in certificate:
            cert_file.write(c.public_bytes(serialization.Encoding.PEM))

http_server = WSGIServer(("localhost", 443), app, keyfile='APIKEY.key', certfile='APICERTIFICATE.crt')
http_server.serve_forever()