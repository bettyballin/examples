from cryptography import x509
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.serialization import pkcs12

# assuming p12 is a PFX/PKCS12 object
with open("container.pfx", 'wb') as f:
    f.write(p12.export())