from nacl.public import SealedBox, PublicKey

public_bytes = b'your_public_key_bytes_here'
data = b'your_data_here'

sealed_box_encryptor = SealedBox(PublicKey(public_bytes))
encrypted_data = sealed_box_encryptor.encrypt(data)

print(encrypted_data)