from ecdsa import VerifyingKey, SECP256k1

# Replace with your compressed key bytes
compressed = b'\x02\x11\xae\xaa\x4a\x47\x94\x2d\x48\x6b\x54\xe4\xf3\xa1\x0c\xfd\xba\x87\xff\xd6\xbc\xf0\xe8\x76\xcc\xc6\x05\xdd\xf5\x14\x18\x9c'

vk = VerifyingKey.from_string(compressed, curve=SECP256k1)
uncompressed = vk.to_string('uncompressed')

print(uncompressed.hex())