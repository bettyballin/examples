from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.primitives.asymmetric.utils import decode_dss_signature
from cryptography.hazmat.primitives.serialization import load_pem_private_key
from cryptography.hazmat.primitives import hashes
import base64
import json

def sign_payload(private_key, data):
    payload = json.dumps(data, separators=(',', ':')).encode('utf-8')
    print(payload.decode('utf-8'))

    sig = private_key.sign(
        payload,
        ec.ECDSA(hashes.SHA256())
    )

    return sig

privateKeyPem = b'''-----BEGIN PRIVATE KEY-----
MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgrW9XiIs4/Kb0q8kl
TmF3oIwSn4NO3xAjs08F0lJ/5UOhRANCAAQykdP4c0ozvOOHHSNkMfLNCWRstXTG
TQf9MWjqB9PbeKyHnxuU82FisUjnVD9zO+QDAK0tnP/qzWf8zxoD0vVW
-----END PRIVATE KEY-----'''

privateKey = load_pem_private_key(privateKeyPem, password=None, backend=default_backend())
data = {"key1": "value1", "key2": "value2"}
signatureDER = sign_payload(privateKey, data)

# Convert signature format
(r, s) = decode_dss_signature(signatureDER)
signatureP1363 = r.to_bytes(32, byteorder='big') + s.to_bytes(32, byteorder='big')
print(base64.b64encode(signatureP1363).decode('utf-8'))