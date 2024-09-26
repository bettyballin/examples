from nacl.public import PrivateKey, SealedBox

private_bytes = b'\x04\x20\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15\x16\x17\x18\x19'
encrypted_data = b'\x04\x20\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15\x16\x17\x18\x19'

private_key_obj = PrivateKey(private_bytes)
sealed_box_decryptor = SealedBox(private_key_obj)

decrypted_data = sealed_box_decryptor.decrypt(encrypted_data)

print(decrypted_data)