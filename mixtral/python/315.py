from api import app
import pem
from gevent.pywsgi import WSGIServer

Mylist = [ele for ele in pem.parse_file(r"C:\Desktop\MyPEMFile.pem") if isinstance(ele, (pem.RSAPrivateKey, pem.Certificate))]
key, certs = Mylist[0], ''.join([str(c) for c in Mylist[1:]])

with open("APIKEY.key", "w") as f_k, open("APICERTIFICATE.crt", "w") as f_c:
    f_k.write(str(key))
    f_c.write(certs)

host = 'localhost'
port = 5000

http_server = WSGIServer((host, port), app, keyfile='APIKEY.key', certfile='APICERTIFICATE.crt')
http_server.serve_forever()