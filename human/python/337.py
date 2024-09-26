from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

xcode = b'-----BEGIN PUBLIC KEY-----\nMHYwEAYHKoZIzj0CAQYFK4EEACIDYgAEFpCnTrJFQq0mZBvy+vzl9noKLZ4/s1cf\nI6hygug6s8dvBreMhabAcAbbhSa1losjCxV450nq92W9ZymonYasaAuhshDWjmvx2\nqTXHEpVEVb9GawqX6XqpWtIBf+meHKS\n-----END PUBLIC KEY-----'

pub_key = serialization.load_pem_public_key(xcode, default_backend())

print(pub_key.public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
).decode())