import base64
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

xcode_data = "BJSCZtBatd2BYEHtyLB0qTZNlphKf3ZTGI6Nke3dSxIDpyP9FWMZbG0zcdIXWENyndskfxV0No/yz369ngL2EHZYw6ggNysOnZ5IQSPOLFFl44m1aAk0o0NdaRXTVAz4jQ=="
public_key_data = base64.b64decode(xcode_data)[1:]  # Skip first byte ("04")

public_key_obj = serialization.load_der_public_key(
    public_key_data,
    backend=default_backend()
)