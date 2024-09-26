from cryptography.hazmat.primitives import hashes, serialization

def main():
    # Example usage of hashes
    digest = hashes.Hash(hashes.SHA256())
    digest.update(b"Hello, world!")
    hash_value = digest.finalize()
    print(f"Hash value: {hash_value.hex()}")

    # Example usage of serialization
    private_key = serialization.load_pem_private_key(
        b"-----BEGIN PRIVATE KEY-----\n"
        b"MC4CAQAwBQYDK2VwBC4EAQQG2OaF8l5v8W+gjLgQr1jEzr2c2DzQ4w8nUUVS2G3\n"
        b"-----END PRIVATE KEY-----\n",
        password=None,
    )
    print(f"Private key: {private_key.private_bytes(encoding=serialization.Encoding.PEM, format=serialization.PrivateFormat.TraditionalOpenSSL, encryption_algorithm=serialization.NoEncryption()).decode()}")

if __name__ == "__main__":
    main()