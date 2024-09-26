import datetime
import jwt
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.backends import default_backend

serviceID = "abc"
iam_url = "https://example.com"  # Replace with your IAM URL
secret = """-----BEGIN RSA PRIVATE KEY-----
...your private key here...
-----END RSA PRIVATE KEY-----"""

due_date = datetime.datetime.now() + datetime.timedelta(minutes=10)
header = {"alg": "RS256"}
expiry = int(due_date.timestamp())
payload = {
    "iss": serviceID,
    "sub": serviceID,
    "exp": expiry,
    "aud": iam_url + "/oauth2/access_token"
}

priv_rsakey = serialization.load_pem_private_key(
    secret.encode('utf-8'),
    password=None,
    backend=default_backend()
)

token = jwt.encode(payload, priv_rsakey, algorithm='RS256')
print(token)