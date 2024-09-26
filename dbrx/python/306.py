import gmpy2
from hashlib import SHA256

P = 0xff600483db6abfc5b45eab78594b3533d550d9f1bf2a992a7a8daa6dc34f8045ad4e6e0c429d334eeeaaefd7e23d4810be00e4cc1492cba325ba81ff2d5a5b305a8d17eb3bf4a06a349d392e00d329744a5179380344e82a18c47933438f891e22aeef812d69c8f75e326cb70ea000c3f776dfdbd604638c2ef717fc26d02e17
Q = 0xe21e04f911d1ed7991008ecaab3bf775984309c3
domain_parameter_seed = b'180180ee2f0ae4a7b3a1ab1b8414228913ef2911'
ggen = gmpy2.mpz(6767656e16)
index = gmpy2.mpz(79)

def compute_gen():
    k = (P - 1) // Q
    for count in range(1, 0xffff):
        U = domain_parameter_seed + bytes(ggen.to_bytes()) + index.to_bytes() + count.to_bytes(2, 'big')
        W = gmpy2.mpz(int.from_bytes(SHA256(U).digest(), 'big'))
        g = pow(W, k, P)
        if g != 1:
            break

    return g

print(compute_gen())