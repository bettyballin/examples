import json
from Crypto.PublicKey import RSA
from Crypto.Signature import pkcs1_15
from Crypto.Hash import SHA256
import base64

private_key = RSA.import_key(open('/etc/ssl/nginx/snbcsr.key').read())

# assuming 'actual' is a defined variable, if not define it
actual = {'your_data': 'here'}  # replace with your actual data

message = json.dumps(actual).encode('utf-8')

h = SHA256.new()

h.update(message)

signature = pkcs1_15.new(private_key).sign(h)

encodedSignature = base64.b64encode(signature)

print(encodedSignature.decode('utf-8'))