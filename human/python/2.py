from M2Crypto import DSA, BIO

dsa = DSA.gen_params(1024)
mem = BIO.MemoryBuffer()
dsa.gen_key()
dsa.save_key_bio(mem, cipher=None)
dsa.save_pub_key_bio(mem)
print(mem.getvalue())