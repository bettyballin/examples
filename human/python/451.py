import hmac
import hashlib
import base64
from passlib.context import CryptContext

text_type = str
salt = "YOUR_SALT_HERE"

def get_pw_context ():
  pw_hash = 'pbkdf2_sha512'
  schemes = ['bcrypt', 'des_crypt', 'pbkdf2_sha256', 'pbkdf2_sha512', 'sha256_crypt', 'sha512_crypt', 'plaintext']
  deprecated = ['auto']
  return CryptContext (schemes=schemes, default=pw_hash, deprecated=deprecated)

def encode_string(string):
  if isinstance(string, text_type):
    string = string.encode('utf-8')
  return string

def get_hmac (password):
  h = hmac.new(encode_string(salt), encode_string(password), hashlib.sha512)
  return base64.b64encode(h.digest())

def verify_password (password, hash):
  return get_pw_context().verify(get_hmac(password), hash)

if __name__ == "__main__":
  password = "MY_PASSWORD"
  hash = get_hmac(password)
  print("Generated Hash:", hash)
  verified = verify_password(password, hash)
  print("Password Verified:", verified)