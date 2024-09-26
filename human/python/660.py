from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.backends import default_backend

def bytesToKey(salt, password):
  bytes = b''
  last = b''
  while len(bytes) < 48:
    md5 = hashes.Hash(hashes.MD5(), backend=default_backend())
    md5.update(last + password + salt)
    last = md5.finalize()
    bytes += last
  return bytes[:48]