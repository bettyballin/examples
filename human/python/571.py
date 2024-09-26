# Short key only for testing purposes!
pkcs8 = '''-----BEGIN PRIVATE KEY-----
MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA2gdsVIRmg5IH0rG3
u3w+gHCZq5o4OMQIeomC1NTeHgxbkrfznv7TgWVzrHpr3HHK8IpLlG04/aBo6U5W
2umHQQIDAQABAkEAu7wulGvZFat1Xv+19BMcgl3yhCdsB70Mi+7CH98XTwjACk4T
+IYv4N53j16gce7U5fJxmGkdq83+xAyeyw8U0QIhAPIMhbtXlRS7XpkB66l5DvN1
XrKRWeB3RtvcUSf30RyFAiEA5ph7eWXbXWpIhdWMoe50yffF7pW+C5z07tzAIH6D
Ko0CIQCyveSTr917bdIxk2V/xNHxnx7LJuMEC5DcExorNanKMQIgUxHRQU1hNgjI
sXXZoKgfaHaa1jUZbmOPlNDvYYVRyS0CIB9ZZee2zubyRla4qN8PQxCJb7DiICmH
7nWP7CIvcQwB
-----END PRIVATE KEY-----'''
message = b'The quick brown fox jumps over the lazy dog'

def main():
    # 1. PyCryptodome (implicit hashing)
    print("PyCryptodome (implicit hashing):")
    from Crypto.Signature import pkcs1_15
    from Crypto.Hash import SHA256
    from Crypto.PublicKey import RSA

    privateKey = RSA.import_key(pkcs8)
    digest = SHA256.new(message)
    signature = pkcs1_15.new(privateKey).sign(digest)
    print(signature.hex())

    # 2. Cryptography (implicit hashing)
    print("\nCryptography (implicit hashing):")
    from cryptography.hazmat.primitives import hashes
    from cryptography.hazmat.primitives.asymmetric import padding
    from cryptography.hazmat.primitives import serialization

    privateKey = serialization.load_pem_private_key(
        pkcs8.encode('utf8'),
        password=None,
    )
    digest = hashes.SHA256()
    signature = privateKey.sign(
        message,
        padding.PKCS1v15(),
        digest
    )
    print(signature.hex())

    # 3. Cryptography (explicit hashing)
    print("\nCryptography (explicit hashing):")
    from cryptography.hazmat.primitives.asymmetric import utils

    digest = hashes.SHA256()
    hasher = hashes.Hash(digest)
    hasher.update(message)
    hash = hasher.finalize()
    signature = privateKey.sign(
         hash,
         padding.PKCS1v15(),     
         utils.Prehashed(digest) # The digest must still be specified because the digest ID is included in the signature.
    )
    print(signature.hex())

    # 4. Cryptography (explicit hashing), inverse hash
    print("\nCryptography (explicit hashing), inverse hash:")
    hashBA  = bytearray(hash)
    hashBA.reverse()
    hashReversed = bytes(hashBA)
    signature = privateKey.sign(
        hashReversed,
        padding.PKCS1v15(),     
        utils.Prehashed(digest) # The digest must still be specified because the digest ID is included in the signature.
    )
    print(signature.hex())

if __name__ == "__main__":
    main()