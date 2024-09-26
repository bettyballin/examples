
from api import app
from gevent.pywsgi import WSGIServer
import pem
from pem import RSAPrivateKey, Certificate
import os

pem_file_path = r"C:\Desktop\MyPEMFile.pem"
key_file_path = "APIKEY.key"
cert_file_path = "APICERTIFICATE.crt"

# Only parse the PEM file if either the key or the certificate file doesn't exist
if not os.path.exists(key_file_path) or not os.path.exists(cert_file_path):
    parsed_pem = pem.parse_file(pem_file_path
