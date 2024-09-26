user_certificate_bytes = pkcs12.serialize_key_and_certificates(
    name=None,
    key=key,
    cert=certificate,
    cas=None,
    encryption_algorithm=serialization.NoEncryption()  # or serialization.BestAvailableEncryption(b"password")
)