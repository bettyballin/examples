import base64

raw_key = """-----BEGIN PUBLIC KEY-----
MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAEFpCnTrJFQq0mZBvy+vzl9noKLZ4/s1cf
I6hygug6s8dvBreMhabAcAbbhSa1losjCxV450nq92W9ZymonYasaAuhshDWjmvx
2qTXHEpVEVb9GawqX6XqpWtIBf+meHKS
-----END PUBLIC KEY-----"""

# Remove the header and footer
key_without_headers = raw_key.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "")

# Remove whitespace
key_without_whitespace = key_without_headers.replace("\n", "")

# Decode the key
decoded_key = base64.b64decode(key_without_whitespace)

print(decoded_key)