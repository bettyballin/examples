import hashlib
import os

class HashBackend:
    def __init__(self, algorithm='sha256'):
        self.algorithm = algorithm

    def get_hash(self, password):
        m = getattr(hashlib, self.algorithm)()
        m.update(password.encode('utf-8'))
        return m.hexdigest()

class HighLevelCrypto:
    def __init__(self, backend):
        self.backend = backend

    def GetHash(self, input_password):
        return self.backend.get_hash(input_password)

class OpenSSLBackend:
    def __init__(self, algorithm='sha256'):
        self.algorithm = algorithm

    def get_hash(self, password):
        command = f"echo -n '{password}' | openssl dgst -{self.algorithm}"
        return os.popen(command).read().split()[1]

class YourCode:
    def __init__(self, high_level_crypto):
        self.high_level_crypto = high_level_crypto

    def call_GetHash(self, input_password):
        return self.high_level_crypto.GetHash(input_password)

# Example usage
hash_backend = HashBackend()
high_level_crypto = HighLevelCrypto(hash_backend)
your_code = YourCode(high_level_crypto)
print(your_code.call_GetHash("password123"))

# Using OpenSSL backend
openssl_backend = OpenSSLBackend()
high_level_crypto = HighLevelCrypto(openssl_backend)
your_code = YourCode(high_level_crypto)
print(your_code.call_GetHash("password123"))