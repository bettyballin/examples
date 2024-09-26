import json
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend
import base64

x509pem = """-----BEGIN PUBLIC KEY-----
MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEMpHT+HNKM7zjhx0jZDHyzQlkbLV0
xk0H/TFo6gfT23ish58blPNhYrFI51Q/czvkAwCtLZz/6s1n/M8aA9L1Vg==
-----END PUBLIC KEY-----"""

public_key = serialization.load_pem_public_key(
    x509pem.encode(),
    backend=default_backend()
)

data_in = {
    "key1": "value1",
    "key2": "value2"
}

signature = "KIkBK4pxSFq/UdsPb/mYCC3y7iAJlULC/jizNp9DrvFFIvZaUjx/M0SAQC7CeBIlLmKzfkGx1fOr7OJ8VlwAdg=="

def verify_signature(signature, public_key, data_in):
    data_str = json.dumps(data_in, sort_keys=True)
    data_buf = data_str.encode()
    sig_buf = base64.b64decode(signature)
    try:
        public_key.verify(
            sig_buf,
            data_buf,
            ec.ECDSA(hashes.SHA256())
        )
        return True
    except:
        return False

verified = verify_signature(signature, public_key, data_in)
print(verified)