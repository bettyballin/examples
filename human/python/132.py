from passlib.context import CryptContext

def _get_pwd_context(app):
    schemes = ["pbkdf2_sha256"]
    pw_hash = "pbkdf2_sha256"
    deprecated = ["pbkdf2_sha1"]
    return CryptContext(schemes=schemes, default=pw_hash, deprecated=deprecated)

pwd_context = _get_pwd_context(None)