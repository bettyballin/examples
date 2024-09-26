from Crypto.PublicKey import RSA
from Crypto.Util.number import bytes_to_long, long_to_bytes

full = RSA.generate(2048)

# construct key using only n and d
try:
    # pycrypto >=2.5, only tested with _slowmath
    impl = RSA.RSAImplementation(use_fast_math=False)
    partial = impl.construct((full.n, 0))
    partial.key.d = full.d
except TypeError:
    # pycrypto <=2.4.1
    partial = RSA.construct((full.n, 0, full.d))

pub = full.publickey()

# create message with padding
# http://en.wikipedia.org/wiki/RSA_(algorithm)#Padding_schemes
cleartext = b"Hello, World!"

signature = partial.sign(cleartext, None)

print("validating message: ", pub.verify(cleartext, signature))

message = pub.encrypt(cleartext, None)

# bypassing the blinding step on decrypt
enc_msg=map(bytes_to_long, message)
dec_msg = map(partial.key._decrypt, enc_msg)

print("decrypting: ")
for m in dec_msg:
    print(long_to_bytes(m))