from ecdsa import VerifyingKey, SECP256k1

# assuming x_32 and y_32 are 32-byte strings representing x and y coordinates
x_32 = b'\x01\x1a\xe2\xaaJ\x84\x94-\x48kT\xe4\xf3\xa1\x0c\xfd\xba\x87\xff\xd6\xbc\xf0\xe8v\xcc\xc6\x05\xdd\xf5\x14\x18'
y_32 = b'\x9c\xc1\x36\x1d\xdc!"\xc1\x9fY\xfe\x94S\xdd\xa5\x9e\x75?\x86t\x13\x95S\x57.\xf2Lc\xe9\x9e\x69\x94'

raw = x_32 + y_32
vk = VerifyingKey.from_string(raw, curve=SECP256k1)
uncompressed = vk.to_string('uncompressed')

print(uncompressed.hex())