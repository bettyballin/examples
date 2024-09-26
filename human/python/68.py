from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import serialization

# assuming loadedPublic is a public key object and messageHashed is a hashed message
# assuming unblind is an unblinded signature

verify = loadedPublic.verify(
    messageHashed,
    unblind,
    padding.PSS(
        mgf=padding.MGF1(hashes.SHA256()),
        salt_length=padding.PSS.MAX_LENGTH
    ),
    hashes.SHA256()
)