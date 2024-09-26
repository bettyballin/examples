from cryptography import hazmat
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding

privateKey = b"...your private key..."  # your private key
certificateChain = [b"...cert1...", b"...cert2..."]  # list of certificates in the chain

password = b"myPassword"

pkcs12Data = serialization.pkcs12.serialize_key_and_certificates(
    name=b"My Identity",
    key=privateKey,
    cert=certificateChain[0],
    cas=certificateChain[1:],
    encryption_algorithm=serialization.BestAvailableEncryption(password)
)

with open("myIdentity.p12", "wb") as f:
   f.write(pkcs12Data)