import json

token = {
    'iss': 'https://sandbox.cds-hooks.org',
    'aud': 'http://127.0.0.1:8000/cds-services',
    'exp': 1594230900,
    'iat': 1594230600,
    'jti': 'efb3773d-3a28-43e2-9fbc-b936a9ae388b'
}

print(json.dumps(token))