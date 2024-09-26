import datetime
import jwt
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.backends import default_backend

serviceID = "your_service_id"
iam_url = "your_iam_url"
secret = "your_secret"

due_date = datetime.datetime.now() + datetime.timedelta(minutes=10)

header = {"alg": "RS256"}
payload = {
    "iss": serviceID,
    "sub": serviceID,
    "exp": int(due_date.timestamp()),
    "aud": iam_url + "/oauth2/access_token"
}

priv_rsakey = serialization.load_pem_private_key(
    secret.encode('utf8'),
    password=None,
    backend=default_backend()
)

token = jwt.encode(payload, priv_rsakey, algorithm='RS256')

print(token)