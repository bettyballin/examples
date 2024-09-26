
import jwt
import requests
import base64
from ecdsa import VerifyingKey, NIST384p
from ecdsa.util import sigdecode_der

# Fetch the JWKS
jwks_url = 'https://sandbox.cds-hooks.org/.well-known/jwks.json'
jwks_response = requests.get(jwks_url)
jwks = j
