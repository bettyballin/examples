import ssl
from wsgiref.simple_server import make_server, WSGIServer
from yourapp import app  # replace 'yourapp' with the actual module name

cert_and_key = "C:\\Desktop\\MyPEMFile.pem"

http_server = WSGIServer(("localhost", 443), app, 
    keyfile=cert_and_key, certfile=cert_and_key)

http_server.serve_forever()