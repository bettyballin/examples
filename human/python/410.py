from base64 import urlsafe_b64decode
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.hmac import HMAC
from cryptography.hazmat.backends import default_backend

# Replace with your values
c = "your_base64_encoded_data"
k = "your_base64_encoded_signing_key"

bin_data = urlsafe_b64decode(c)
signing_key = urlsafe_b64decode(k)[:16]

client_data = bin_data[:-32]
client_hmac = bin_data[-32:]

print('Client HMAC:', client_hmac.hex())

real_hmac = HMAC(signing_key, hashes.SHA256(), default_backend())
real_hmac.update(client_data)
real_hmac = real_hmac.finalize()

print('Real HMAC  :', real_hmac.hex())

if client_hmac == real_hmac:
    print('Token seems valid!')
else:
    print('Token does NOT seem valid!')