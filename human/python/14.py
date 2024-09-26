import array
import os
from Crypto.Cipher import AES

class Secret(object):
  def __init__(self, secret=None):
    if secret is None: secret = os.urandom(16)
    self.secret = secret
    self.reset()
  def counter(self):
    for i, c in enumerate(self.current):
      self.current[i] = (c + 1) % 256
      if self.current[i]: break
    return self.current.tobytes()
  def reset(self):
    self.current = array.array('B', self.secret)

secret = Secret()
crypto = AES.new(os.urandom(32), AES.MODE_CTR, counter=secret.counter)
encrypted = crypto.encrypt(16*'a' + 16*'b' + 16*'c')
secret.reset()
crypto = AES.new(crypto.key, AES.MODE_CTR, counter=secret.counter)
print(crypto.decrypt(encrypted))