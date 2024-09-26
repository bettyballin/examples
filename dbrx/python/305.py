import base64

der_encoded_ephemeral_public_key = b"..."
ephemeral_public_key = base64.b64decode(der_encoded_ephemeral_public_key)

if __name__ == "__main__":
    print(ephemeral_public_key)