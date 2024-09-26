from werkzeug.security import generate_password_hash
from werkzeug.local import LocalProxy

def encrypt_password(password):
    signed = password
    return generate_password_hash(signed)

_pwd_context = LocalProxy(lambda: generate_password_hash)