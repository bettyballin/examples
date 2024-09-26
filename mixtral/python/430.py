from jose import jwt
import datetime

# Define a payload
payload = {
    'exp': datetime.datetime.utcnow() + datetime.timedelta(days=1),
    'iat': datetime.datetime.utcnow(),
    'sub': '1234567890'
}

# Load the private RSA key
priv_rsakey = open('private_key.pem', 'r').read()

# Encode the payload
token = jwt.encode(payload, priv_rsakey, algorithm='RS256')

print(token)